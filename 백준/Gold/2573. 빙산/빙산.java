import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int board[][];
    static int temp[][];
    static boolean visit[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int year;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        temp = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(true){
        visit = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] != 0 && !visit[i][j]){
                    bfsArea(i,j);
                    count++;
                }
            }
        }
        
        
        if(count >= 2){
            bw.write(year+"");
            bw.flush();
            bw.close();
            return;
        } else if(count == 0){
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }
        temp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] != 0){
                    int zero = 0;
                    for(int k = 0; k < 4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        
                        if(board[nr][nc] == 0){
                            zero++;
                        }
                    }
                    int newResult = board[i][j] - zero;
                    temp[i][j] = Math.max(0, newResult);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            board[i] = temp[i].clone();
        }
        year++;
    }
    
    
    }

    
    static void bfsArea(int r, int c){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r,c});
        visit[r][c] = true;
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(board[nr][nc] != 0 && !visit[nr][nc]){
                    visit[nr][nc] = true;
                    deque.add(new int[]{nr,nc});
                }
            }
        }
    }
}