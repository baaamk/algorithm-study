import java.util.*;

class Solution {
    
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int[] solution(String[][] places) {
        char[][] board = new char[5][5];
        int[] answer = new int[5];
        
        for(int t = 0; t < 5; t++){
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    board[i][j] = places[t][i].charAt(j);
                }
            }
            
            if(check(board)){
                answer[t] = 1;
            } else {
                answer[t] = 0;
            }
        }
        return answer;
    }
    
    boolean check(char[][] board){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(board[i][j] == 'P'){
                    if(!bfs(board,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    boolean bfs(char[][] board, int r, int c){
        boolean[][] visit = new boolean[5][5];
        visit[r][c] = true;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {r,c,0});
        
        while(!dq.isEmpty()){
            int[] cur = dq.pop();
            int cr = cur[0];
            int cc = cur[1];
            int dist = cur[2];
            
            if(dist >= 2){
                continue;
            }
            
            for(int i = 0; i < 4 ;i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nc >=0 && nc < 5 && nr < 5){
                    
                    if(!visit[nr][nc] && board[nr][nc] == 'X'){
                        visit[nr][nc] = true;
                    }
                    if(!visit[nr][nc] && board[nr][nc] == 'P'){
                        return false;
                    }
                    
                    if(!visit[nr][nc] && board[nr][nc] == 'O'){
                        visit[nr][nc] = true;
                        dq.add(new int[] {nr,nc,dist + 1});
                    }
                }
            }
        }
        return true;
    }
}