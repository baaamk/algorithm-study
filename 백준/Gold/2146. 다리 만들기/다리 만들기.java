import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int count;
    static int[][] board;
    static int[][] dist;
    static boolean[][] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dist = new int[n][n];
        visit = new boolean[n][n];
        
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1 && !visit[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] > 0){
                    dist[i][j] = 0;
                    deque.add(new int[] {i,j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nc >=0 && nr < n && nc < n){
                    if(board[nr][nc] == 0){
                        board[nr][nc] = board[cr][cc];
                        dist[nr][nc] = dist[cr][cc] + 1;
                        deque.add(new int[] {nr,nc});
                    } else if(board[nr][nc] != board[cr][cc]){
                        answer = Math.min(answer, dist[nr][nc] + dist[cr][cc]);
                    }
                }
            }
        }
        bw.write(answer +"");
        bw.flush();
        bw.close();
    }
    
    static void bfs(int r, int c){
        Deque<int[]> deque = new ArrayDeque<>();
        visit[r][c] = true;
        board[r][c] = count;
        
        deque.add(new int[] {r,c});
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0 ; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nc >=0 && nc < n && nr < n){
                    if(board[nr][nc] == 1 && !visit[nr][nc]){
                        visit[nr][nc] = true;
                        board[nr][nc] = count;
                        deque.add(new int[] {nr,nc});
                    }
                }
            }
        }
    }
    
    
}