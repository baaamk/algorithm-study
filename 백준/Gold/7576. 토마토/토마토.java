import java.util.*;
import java.io.*;

class Main {
    static int m, n;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Deque<int[]> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    deque.add(new int[] {i,j});
                }
            }
        }
        
        bfs();
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0){
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    return;
                }
                max = Math.max(max, board[i][j]);
            }
        }
        bw.write((max - 1) + "");
        bw.flush();
        bw.close();
    }
    
    static void bfs(){
               
        while(!deque.isEmpty()){
            int[] current = deque.poll();
            int cr = current[0];
            int cc = current[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    if(board[nr][nc] == 0){
                        board[nr][nc] = board[cr][cc] + 1;
                        deque.add(new int[] {nr,nc});
                        }
                    }
                }
            }
        }
        
    }
