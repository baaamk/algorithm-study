import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) {
        int answer = 0;
        //최소 루트로 가되 가장 먼 노드.
        List<Integer>[] graph = new ArrayList[n + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        boolean[] visited = new boolean[n + 1];
        int[] count = new int[n+1];
        
        dq.add(1);
        visited[1] = true;
        
        while(!dq.isEmpty()){
            int cur = dq.pop();
            
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    count[next] = count[cur] + 1;
                    dq.add(next);
                }
            }
        }
        
        int maxDistance = 0;
        for(int dis : count){
            maxDistance = Math.max(dis,maxDistance);
        }
        
        for(int dis : count){
            if(dis == maxDistance){
                answer++;
            }
        }
        
        
        return answer;
    }
}