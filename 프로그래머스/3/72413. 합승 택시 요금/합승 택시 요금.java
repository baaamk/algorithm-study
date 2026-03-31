import java.util.*;

class Solution {
    List<int[]>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares){
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            
            graph[u].add(new int[] {v,w});
            graph[v].add(new int[] {u,w});
        }
        
        int[] distS = make(n, s);
        int[] distA = make(n, a);
        int[] distB = make(n, b);
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            if (distS[i] != Integer.MAX_VALUE && distA[i] != Integer.MAX_VALUE && distB[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
            }
        }
        return answer;
    }
    
    int[] make(int n, int start){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        dist[start] = 0;
        pq.add(new int[] {start, 0});
        
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
                
                if (dist[nextNode] > dist[now] + nextWeight) {
                    dist[nextNode] = dist[now] + nextWeight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
            
        }
        return dist;
    }
}