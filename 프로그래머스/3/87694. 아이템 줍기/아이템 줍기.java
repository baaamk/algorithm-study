import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        int[][] map = new int[102][102];
        boolean[][] visit = new boolean[102][102];
        for(int[] rect : rectangle){
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    if(i > x1 && i < x2 && j < y2 && j > y1){
                        map[i][j] = 2;
                    } else if(map[i][j] != 2) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        visit[characterX*2][characterY*2] = true;
        
        dq.add(new int[] {characterX*2, characterY*2,0});
        
        while(!dq.isEmpty()){
            int[] cur = dq.pop();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            if(r == itemX*2 && c == itemY*2){
                return dist/2;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 102 && nc < 102 && nr > 0 && nc >0){
                    if(!visit[nr][nc] && map[nr][nc] == 1){
                        visit[nr][nc] = true;
                        dq.add(new int[] {nr,nc, dist+1});
                    }
                }
            }
        }
        
        return 0;
    }
}