import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[][] board;
    static int[][][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        dist = new int[n][m][2];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j) - '0';
                Arrays.fill(dist[i][j], -1);
            }
        }
        
        int answer = bfs(0,0,0);
        bw.write(answer +"");
        bw.flush();
        bw.close();
    }
    
    static int bfs(int r, int c, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r, c, b});
        dist[r][c][b] = 1;
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cb = cur[2];
            if(cr == n-1 && cc == m-1){
                return dist[cr][cc][cb];
            }
            for(int i = 0 ; i < 4; i++){
                int nr = cr +dr[i];
                int nc = cc +dc[i];
                
                
                if(nr >=0 && nc >= 0 && nr < n && nc <m){
                    if(board[nr][nc] == 0 && dist[nr][nc][cb] == -1){
                        dist[nr][nc][cb] = dist[cr][cc][cb] + 1;
                        deque.add(new int[] {nr, nc, cb});
                    } else if(cb == 0 && board[nr][nc] == 1 && dist[nr][nc][1] == -1){
                        dist[nr][nc][1] = dist[cr][cc][cb] + 1;
                        deque.add(new int[] {nr, nc, 1});
                    }
                }
            }
        }
        return -1;
    }
}