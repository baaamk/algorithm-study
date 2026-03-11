import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int[][] board;
    static List<int[]> empty = new ArrayList<>();
    static int max = 0;
    static int[] dr = {-1,1, 0,0};
    static int[] dc = {0,0, -1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0){
                    empty.add(new int[] {i,j});
                }
            }
        }
        
        dfs(0,0);
        bw.write(max + "");
        bw.flush();
        bw.close();
        
    }
    
    static void dfs(int depth, int start){
        if(depth == 3){
            boolean[][] visit = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 2 && !visit[i][j]){
                        bfs(i,j, visit);
                    } else if(board[i][j] == 1){
                        visit[i][j] = true;
                    } 
                }
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visit[i][j]){
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
            return;
        }
        
        for(int i = start; i < empty.size(); i++){
            int r = empty.get(i)[0];
            int c = empty.get(i)[1];
            
            board[r][c] = 1;
            dfs(depth + 1, i + 1);
            board[r][c] = 0;
        }
    }
    
    static void bfs(int r, int c, boolean[][] visit){
        Deque<int[]> deque = new ArrayDeque<>();
        visit[r][c] = true;
        deque.add(new int[] {r,c});
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr < n && nc < m && nr >= 0 && nc >= 0){
                    if(!visit[nr][nc] && board[nr][nc] != 1){
                        visit[nr][nc] = true;
                        deque.add(new int[] {nr,nc});
                    }
                }
            }
        }
        
    }
}