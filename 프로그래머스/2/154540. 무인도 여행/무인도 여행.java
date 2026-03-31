import java.util.*;

class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int n;
    int m;
    boolean[][] visit;
    char[][] board;
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        board = new char[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = maps[i].charAt(j);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visit[i][j] && board[i][j] != 'X'){
                    visit[i][j] = true;
                    list.add(bfs(i,j));
                }
            }
        }
        if(list.isEmpty()){
            return new int[] {-1};
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    int bfs(int r, int c){
        int result = board[r][c] - '0';
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {r,c});
        
        while(!dq.isEmpty()){
            int[] cur = dq.pop();
            int rr = cur[0];
            int rc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = rr + dr[i];
                int nc = rc + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    if(!visit[nr][nc] && board[nr][nc] != 'X'){
                        visit[nr][nc] = true;
                        result += board[nr][nc] - '0';
                        dq.add(new int[] {nr, nc});
                    }
                }
            }
        }
        return result;
    }
}