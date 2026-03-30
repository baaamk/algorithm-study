import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 1. 거미줄(인접 리스트) 만들기 
        // 노드 번호가 1부터 시작하니까 N+1 크기로 만듭니다.
        List<int[]>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // 양방향 도로 연결! [목적지, 걸리는 시간]
        for (int[] r : road) {
            int u = r[0], v = r[1], time = r[2];
            adj[u].add(new int[]{v, time});
            adj[v].add(new int[]{u, time}); 
        }
        
        // 2. 최단 거리 기록장(dist 배열) 세팅
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 일단 전부 무한대로 초기화
        dist[1] = 0; // 1번 마을(내 위치)은 시간이 0!

        // 3. 다익스트라 엔진 가동 (Priority Queue)
        // 🔥 아까 썼던 그 PQ! 이번엔 "시간(time)이 짧은 순서(오름차순)"로 튀어나오게 세팅
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0}); // {현재 마을, 여기까지 걸린 시간} 시작!

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];
            int time = curr[1];
            
            // 🚨 [시간 초과 방어 로직] 
            // 큐에서 뽑은 시간이 이미 기록된 최단 시간보다 길면? 굳이 탐색할 필요 없음 (스킵!)
            if (time > dist[now]) continue;
            
            // 현재 마을과 연결된 다른 마을들 탐색
            for (int[] next : adj[now]) {
                int nextNode = next[0];
                int nextTime = time + next[1]; // 지금까지 걸린 시간 + 다음 마을 가는 시간
                
                // 새로운 경로가 기존에 알던 시간보다 빠르다면? -> 기록 갱신하고 큐에 넣기!
                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.offer(new int[]{nextNode, nextTime});
                }
            }
        }
        
        // 4. 시간이 K 이하인 마을 개수 세기
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}