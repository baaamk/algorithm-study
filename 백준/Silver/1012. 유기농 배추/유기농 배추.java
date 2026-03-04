import java.util.*;
import java.io.*;

class Main{
    static int t,m,n,k;
    static int[][] board;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            visit = new boolean[n][m];
            int count = 0;
            Deque<int[]> deque = new ArrayDeque<>();
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }
            
            for(int a = 0; a < n; a++){
                for(int b = 0; b < m; b++){
                    if(board[a][b] == 1 && !visit[a][b]){
                        deque.add(new int[] {a,b});
                        visit[a][b] = true;
                        count++;
                        while(!deque.isEmpty()){
                        int[] current = deque.poll();
                        int cr = current[0];
                        int cc = current[1];
                
                        for(int i = 0; i < 4; i++){
                            int nr = cr + dr[i];
                            int nc = cc + dc[i];
                    
                            if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                                if(board[nr][nc] == 1 && !visit[nr][nc]){
                                    deque.add(new int[] {nr, nc});
                                    visit[nr][nc] = true;
                                }
                            }
                        }
                
                    }                        
                        
                    }
                }
            }
            bw.write(count +"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}