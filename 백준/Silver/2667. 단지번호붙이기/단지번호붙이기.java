import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] board;
    static boolean[][] visit;
    static List<Integer> areas = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visit = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = s.charAt(j) - '0';
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1 && !visit[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }
        
        bw.write(count + "");
        bw.newLine();
        areas.sort(Comparator.naturalOrder());
        for(Integer area : areas){
            bw.write(area +"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    static void bfs(int r, int c){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r,c});
        visit[r][c] = true;
        int area = 1;
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >=0 && nc >= 0 && nr < n && nc < n){
                    if(board[nr][nc] == 1 && !visit[nr][nc]){
                        area++;
                        visit[nr][nc] = true;
                        deque.add(new int[] {nr, nc});
                    }
                }
            }
        }
        areas.add(area);
    }
}