import java.util.*;

class Solution {
    List<Integer>[] dp;
    int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        dp = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            
            dp[u].add(v);
            dp[v].add(u);
        }
        int[] answer = new int[sources.length];
        
        make(n, destination);
        for (int i = 0; i < sources.length; i++) {
            int d = dist[sources[i]];
            
            answer[i] = (d == Integer.MAX_VALUE) ? -1 : d;
        }
        
        
        return answer;
    }
    
    void make(int n, int start){
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int currentDist = cur[1];
            
            if(currentDist > dist[now]){
                continue;
            }
            
            for(int next : dp[now]){
                int nextNode = next;
                if(dist[nextNode] > dist[now] + 1){
                    dist[nextNode] = dist[now] + 1;
                    pq.add(new int[] {nextNode, dist[nextNode]});
                }
            }
        };
    }
}