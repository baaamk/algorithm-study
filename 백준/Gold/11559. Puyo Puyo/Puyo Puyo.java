import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0,0,-1,1};
    static int ans;
    static char[][] board1 = new char[12][6];
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = 12;
        m = 6;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                board1[i][j] = s.charAt(j);
            }
        }
        
        
        while(true){
            visited = new boolean[n][m];
            List<int[]> toRemove = new ArrayList<>();
            boolean popped = false;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board1[i][j] == '.'){
                        continue;
                    }
                    if(visited[i][j]){
                        continue;
                    }
                    List<int[]> group = bfs(i,j);
                    if(group.size() >= 4){
                        popped = true;
                        toRemove.addAll(group);
                    }
                }
            }
            if(!popped){
                break;
            }

            for(int[] pos : toRemove){
                board1[pos[0]][pos[1]] = '.';
            }
            
            ans++;
            move();
        }
        
        bw.write(ans +"");
        bw.flush();
        bw.close();
    }
    
    static void move() {
        for (int col = 0; col < 6; col++) {
            int writeRow = 11;

            for (int row = 11; row >= 0; row--) {
                if (board1[row][col] != '.') {
                    char temp = board1[row][col];
                    board1[row][col] = '.';
                    board1[writeRow][col] = temp;
                    writeRow--;
                }
            }
        }
    }
    
    static List<int[]> bfs(int r, int c){
        Deque<int[]> deque = new ArrayDeque<>();
        List<int[]> group = new ArrayList<>();
        char color = board1[r][c];
        
        deque.add(new int[] {r, c});
        visited[r][c] = true;
        group.add(new int[] {r, c});
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr < n && nc < m && nr >= 0 && nc >= 0){
                    if(!visited[nr][nc] && board1[nr][nc] == color){
                        visited[nr][nc] = true;
                        deque.add(new int[] {nr, nc});
                        group.add(new int[] {nr, nc});
                    }
                }
            }
        }

        return group;
    }

}