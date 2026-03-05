import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[][] board;
    static int[][] temp;
    static int[] dr ={-1, 1, 0, 0};
    static int[] dc ={0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = 0;
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                m = Math.max(m, board[i][j]);
            }
        }
        int max = 0;
        for(int t = 0; t < m; t++){
            temp = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] > t) {
                        temp[i][j] = 1;
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(temp[i][j] == 1){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            max = Math.max(max,count);
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
    
    static void bfs(int r, int c){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r, c});
        temp[r][c] = 0;
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc <n){
                    if(temp[nr][nc] == 1){
                        deque.add(new int[] {nr, nc});
                        temp[nr][nc] = 0;
                    }
                }
            }
        }
    }
}