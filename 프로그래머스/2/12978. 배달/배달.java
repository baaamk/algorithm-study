import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<int[]>[] graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] each : road){
            int u = each[0];
            int v = each[1];
            int w = each[2];
            
            graph[u].add(new int[] {v,w});
            graph[v].add(new int[] {u,w});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        dist[1] = 0;
        pq.add(new int[] {1,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int currentDist = cur[1];
            
            if(currentDist > dist[now]){
                continue;
            }
            
            for(int[] next : graph[now]){
                int nextNode = next[0];
                int nextWeight = next[1];
                
                if(dist[nextNode] > dist[now] + nextWeight){
                    dist[nextNode] = dist[now] + nextWeight;
                    pq.add(new int[] {nextNode, dist[nextNode]});
                }
            }
        }
        
        for(int a : dist){
            if(a <= K){
                answer++;
            }
        }
        return answer;
    }
}