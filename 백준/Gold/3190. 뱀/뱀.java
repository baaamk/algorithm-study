import java.util.*;
import java.io.*;

class Main{
    
    static class Dir{
        int sec;
        String dir;
        
        Dir(int sec, String dir){
            this.sec = sec;
            this.dir = dir;
        }
    }
    
    static int n,k,l;
    static int count;
    static int[][] board;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Deque<Dir> deque = new ArrayDeque<>();
    static Deque<int[]> snake = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = 0;
            }
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }
        
        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            deque.add(new Dir(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        
        game();
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
    
    static void game(){
        count = 0;
        int d = 0;
        
        int headR = 0;
        int headC = 0;
        snake.add(new int[]{0, 0});
        board[0][0] = 2;
        
        while(true){
            count++;
            int nr = headR + dr[d];
            int nc = headC + dc[d];
            
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                return;
            }
            if (board[nr][nc] == 2) {
                return;
            }
            
            if(board[nr][nc] == 1){
                board[nr][nc] = 2;
                snake.add(new int[] {nr, nc});
            } else if(board[nr][nc] == 0){
                board[nr][nc] = 2;
                snake.add(new int[] {nr, nc});
                
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
            }
            headR = nr;
            headC = nc;
            
            if(!deque.isEmpty() && deque.peek().sec == count) {
                Dir temp = deque.poll();
                if(temp.dir.equals("L")){
                    d = (d + 3) % 4;
                } else {
                    d = (d + 1) % 4;
                }
            }
        }
    }
}