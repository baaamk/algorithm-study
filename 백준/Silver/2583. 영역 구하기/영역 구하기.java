import java.util.*;
import java.io.*;

class Main {
    static int n,m,k;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Integer> areas = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            
            for(int r = sr; r < er; r++){
                for(int c = sc; c < ec; c++){
                    board[r][c] = 1;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    bfs(i, j);
                    count ++;
                }
            }
        }
        bw.write(count + "");
        bw.newLine();
        
        areas.sort(Comparator.naturalOrder());
        for(Integer a : areas){
            bw.write(a + " ");
        }
        bw.flush();
        bw.close();
    }
    
    static void bfs(int r, int c){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{r, c});
        board[r][c] = 1;
        int area = 1;
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n){
                    if(board[nr][nc] == 0){
                        board[nr][nc] = 1;
                        deque.add(new int[] {nr, nc});
                        area++;
                    }
                }
            }
        }
        areas.add(area);
        
    }
}