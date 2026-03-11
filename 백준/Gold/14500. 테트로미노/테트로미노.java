import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[][] board;
    static boolean[][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max = 0;
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
            }
        }
        visit = new boolean[n][m];
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                visit[i][j] = true;
                dfs(i,j,1,board[i][j]);
                visit[i][j] = false;
                
                checkT(i,j);
            }
        }
        bw.write(max +"");
        bw.flush();
        bw.close();
    }
    
    static void dfs(int r, int c, int depth, int sum){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            if (visit[nr][nc]) {
                continue;
            }

            visit[nr][nc] = true;
            dfs(nr, nc, depth + 1, sum + board[nr][nc]);
            visit[nr][nc] = false;
        }
    }
    
    static void checkT(int r, int c){
        int center = board[r][c];
        for(int skip = 0; skip < 4; skip++){
            int sum = center;
            boolean ok = true;
            for(int d = 0; d < 4; d++){
                if (d == skip) {
                    continue;
                }
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    ok = false;
                    break;
                }
                sum += board[nr][nc];
            }
            if(ok){
                max = Math.max(max, sum);
            }
        }
    }
}