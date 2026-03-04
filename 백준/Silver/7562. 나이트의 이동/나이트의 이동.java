import java.util.*;
import java.io.*;

class Main{
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int l,cr, cc, tr, tc;
    static int[][] board;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for(int tec = 0; tec < n; tec++){
            l = Integer.parseInt(br.readLine());
            Deque<int[]> deque = new ArrayDeque<>();
            board = new int[l][l];
            st = new StringTokenizer(br.readLine());
            cr = Integer.parseInt(st.nextToken());
            cc = Integer.parseInt(st.nextToken());
            board[cr][cc] = 1;
            deque.add(new int[] {cr, cc});
            st = new StringTokenizer(br.readLine());
            tr = Integer.parseInt(st.nextToken());
            tc = Integer.parseInt(st.nextToken());

            bfs(deque);
            
        }
        bw.flush();
        bw.close();
    }
    
    static void bfs(Deque<int[]> deque) throws IOException {
           while(!deque.isEmpty()){
                int[] cur = deque.poll();
                int cr = cur[0];
                int cc = cur[1];
                
                for(int i = 0; i < 8; i++){
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];
                    
                    if(nr >= 0 && nc >= 0 && nr < l && nc < l){
                        if(board[nr][nc] == 0){
                            board[nr][nc] = board[cr][cc] + 1;
                            deque.add(new int[] {nr, nc});
                        }
                    }
                    
                    if(nr == tr && nc == tc){
                        bw.write(board[nr][nc] - 1 + "");
                        bw.newLine();
                        return;
                    }
                }
            }
    }
}