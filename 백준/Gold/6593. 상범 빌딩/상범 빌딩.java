import java.util.*;
import java.io.*;

class Main {
    static int l, r, c;
    static char[][][] board;
    static int[][][] temp;
    static int[] dz ={0,0,0,0,-1,1}; 
    static int[] dr ={-1,1,0,0,0,0}; 
    static int[] dc ={0,0,-1,1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        
        while(true){
            st = new StringTokenizer(br.readLine());
            
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l == 0 && r == 0 && c == 0){
                break;
            }
            Deque<int[]> deque = new ArrayDeque<>();
            board = new char[l][r][c];
            temp = new int[l][r][c];
            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    String s = br.readLine();
                    for(int k = 0; k < c; k++){
                        board[i][j][k] = s.charAt(k);
                        if(board[i][j][k] == 'S'){
                            deque.add(new int[] {i,j,k});
                            board[i][j][k] = '#';
                        }
                    }
                }
                br.readLine();
            }
            boolean escaped = false;
           while(!deque.isEmpty()){
               int[] cur = deque.poll();
               int cz = cur[0];
               int cr = cur[1];
               int cc = cur[2];
               if(board[cz][cr][cc] == 'E'){
                   escaped = true;
                   bw.write("Escaped in " + temp[cz][cr][cc] + " minute(s).");
                   bw.newLine();
                   break;
               }
               
               for(int i = 0; i < 6; i++){
                   int nz = cz + dz[i];
                   int nr = cr + dr[i];
                   int nc = cc + dc[i];
                   
                   
                   if(nz >= 0 && nr >=0 && nc >= 0 && nz < l && nr < r && nc < c){
                       if(board[nz][nr][nc] == '.' || board[nz][nr][nc] == 'E'){
                           if(board[nz][nr][nc] == '.') {
                               board[nz][nr][nc] = '#';
                           }

                           temp[nz][nr][nc] = temp[cz][cr][cc] + 1;
                           deque.add(new int[] {nz,nr,nc});
                       }
                   }
               }
               
           }
            if(!escaped){
                bw.write("Trapped!");
                bw.newLine();
            }
            
        }
        bw.flush();
        bw.close();
    }
   
}