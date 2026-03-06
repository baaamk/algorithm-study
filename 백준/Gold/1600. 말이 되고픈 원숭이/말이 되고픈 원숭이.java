import java.util.*;
import java.io.*;

class Main{
    static int k,n,m;
    static int[][] board;
    static int[][][] dist;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int[] fr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] fc = {1, -1, 2, -2, 2, -2, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        dist = new int[n][m][k + 1];
        
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dist[i][j], -1);
            }
        }
        int answer = bfs(0,0,0);
        bw.write(answer +"");
        bw.flush();
        bw.close();
    }
    
    static int bfs(int r, int c, int f){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r, c, f});
        dist[r][c][f] = 0;
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cf = cur[2];
            if(cr == n - 1 && cc == m - 1){
                return dist[cr][cc][cf];
            }
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int nf = cf;
                
                if(nr >= 0 && nc >= 0 && nr < n && nc <m){
                    if(board[nr][nc] == 0 && (dist[nr][nc][nf] == -1 || dist[nr][nc][nf] > dist[cr][cc][cf] + 1)){
                        dist[nr][nc][nf] = dist[cr][cc][cf] + 1;
                        deque.add(new int[] {nr,nc,nf});
                    }
                }
            }
            
            for(int i = 0; i < 8; i++){
                int nr = cr + fr[i];
                int nc = cc + fc[i];
                int nf = cf + 1;
                
                if(nr >= 0 && nc >= 0 && nr < n && nc <m && nf <= k){
                    if(board[nr][nc] == 0 && (dist[nr][nc][nf] == -1 || dist[nr][nc][nf] > dist[cr][cc][cf] + 1)){
                        dist[nr][nc][nf] = dist[cr][cc][cf] + 1;
                        deque.add(new int[] {nr,nc,nf});
                    }
                }
            }
            
        }
        return -1;
    }
}