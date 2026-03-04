import java.util.*;
import java.io.*;

class Main {
    static int n,m,h;
    static int[][][] board;
    static int[] dr= {-1, 1, 0, 0, 0, 0};
    static int[] dc= {0, 0, -1, 1, 0, 0};
    static int[] dz= {0, 0, 0, 0, -1, 1};
    static Deque<int[]> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        board = new int[h][n][m];
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if(board[i][j][k] == 1){
                        deque.add(new int[] {i, j, k});
                    }
                }
            }
        }
        
        dfs();
        int max = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(board[i][j][k] == 0){
                        bw.write("-1");
                        bw.flush();
                        bw.close();
                        return;
                    }
                    max = Math.max(max, board[i][j][k]);
                }
            }
        }
        bw.write(max - 1+ "");
        bw.flush();
        bw.close();
        

    }
    
    static void dfs(){
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cz = cur[0]; 
            int cr = cur[1]; 
            int cc = cur[2]; 
            
            for(int i = 0; i < 6; i++){
                int nz = cz + dz[i];
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nz >= 0 && nr >=0 && nc >=0 && nz < h && nr < n && nc < m){
                    if(board[nz][nr][nc] == 0){
                        board[nz][nr][nc] = board[cz][cr][cc] + 1;
                        deque.add(new int[] {nz, nr, nc});
                    }
                }
            }
        }
    }
}