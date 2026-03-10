import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int r, c, d;
    static int[][] board;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[] d4r = {-1,1,0,0};
    static int[] d4c = {0,0,-1,1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        move(r, c, d);
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
    
    static void move(int r, int c, int d){
        if(board[r][c] == 0){
            count ++;
            board[r][c] = -1;
        }
        
        if(canClean(r, c)){
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(board[nr][nc] == 0){
                move(nr,nc,d);
            } else {
                move(r,c,d);
            }
        } else {
            int nr = r - dr[d];
            int nc = c - dc[d];
            if(board[nr][nc] == 1){
                return;
            } else {
                move(nr,nc,d);
            }
        }
    }
    
    static boolean canClean(int r, int c){
        boolean ok = false;
        for(int i = 0; i < 4; i ++){
            int nr = r + d4r[i];
            int nc = c + d4c[i];
            
            if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                if(board[nr][nc] == 0){
                    ok = true;
                }
            }
        }
        return ok;
    }
}