import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visit;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        visit = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0,0);
        bw.write(board[n - 1][m - 1] + "");
        bw.flush();
        bw.close();
    }
    
    static void bfs(int r, int c){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r,c});
        visit[r][c] = true;
        int count = 0;
        while(!deque.isEmpty()){
            int[] current = deque.poll();
            int cr = current[0];
            int cc = current[1];
            
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nc >=0 && nr < n && nc < m){
                    if(board[nr][nc] == 1 && !visit[nr][nc]){
                        visit[nr][nc] = true;
                        board[nr][nc] = board[cr][cc] + 1;
                        deque.add(new int[]{nr,nc});
                    }
                }
            }
            
        }
    }
}