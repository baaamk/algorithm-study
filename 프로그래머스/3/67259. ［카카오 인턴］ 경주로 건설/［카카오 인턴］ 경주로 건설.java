import java.util.*;

class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] dist = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[] {0,0,0,-1});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];
            int dir = cur[3];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == 1) continue;
                int nextCost = cost + 100;
                if(dir != -1 && dir != i){
                    nextCost += 500;
                }
                if (dist[nr][nc][i] > nextCost) {
                    dist[nr][nc][i] = nextCost;
                    pq.add(new int[]{nr, nc, nextCost, i});
                }
            }    
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer, dist[N - 1][N-1][i]);
        }
        return answer;
    }
}