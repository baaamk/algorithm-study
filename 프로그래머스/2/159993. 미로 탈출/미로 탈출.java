import java.util.*;

class Solution {
    int n,m;
    boolean[][] visit;
    int[][] dist;
    char[][] board;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visit = new boolean[n][m];
        dist = new int[n][m];
        board = new char[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = maps[i].charAt(j);
            }
        }
        int a = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'S'){
                    visit[i][j] = true;
                    a = toL(i,j);
                }
            }
        }
        if(a == 0){
            return -1;
        }
        visit = new boolean[n][m];
        dist = new int[n][m];
        int b = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'L'){
                    visit[i][j] = true;
                    b = toE(i,j);
                }
            }
        }
        
        if(b == 0){
            return -1;
        }
        
        int answer = a+b;
        return answer;
    }
    
    int toL(int r, int c){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {r,c});
        int a = 0;
        int b = 0;
        while(!dq.isEmpty()){
            int[] cur = dq.pop();
            int rr = cur[0];
            int rc = cur[1];
            if(board[rr][rc] == 'L'){
                return dist[rr][rc];
            }
            for(int i = 0; i < 4; i++){
                int nr = rr + dr[i];
                int nc = rc + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    if(!visit[nr][nc] && board[nr][nc] != 'X'){
                        visit[nr][nc] = true;
                        dist[nr][nc] = dist[rr][rc] + 1;
                        dq.add(new int[] {nr,nc});
                    }
                }
            }
        }
        return 0;
    }
    
    int toE(int r, int c){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {r,c});
        int a = 0;
        int b = 0;
        while(!dq.isEmpty()){
            int[] cur = dq.pop();
            int rr = cur[0];
            int rc = cur[1];
            if(board[rr][rc] == 'E'){
                return dist[rr][rc];
            }
            for(int i = 0; i < 4; i++){
                int nr = rr + dr[i];
                int nc = rc + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    if(!visit[nr][nc] && board[nr][nc] != 'X'){
                        visit[nr][nc] = true;
                        dist[nr][nc] = dist[rr][rc] + 1;
                        dq.add(new int[] {nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}