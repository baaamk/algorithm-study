import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1 && !visit[i][j]){
                    count++;
                    int area = bfs(i,j);
                    max = Math.max(area, max);
                }
            }
        }
        
        bw.write(count+ "");
        bw.newLine();
        bw.write(max +"");
        bw.flush();
        bw.close();

    }
    
    static int bfs(int x, int y){
        Deque<int[]> deque = new ArrayDeque<>();
        int[] temp = {x, y};
        deque.add(temp);
        visit[x][y] = true;
        int area = 1;
        
        while(!deque.isEmpty()){
            int[] current = deque.poll();
            int cx = current[0];
            int cy = current[1];
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(board[nx][ny] == 1 && !visit[nx][ny]){
                        visit[nx][ny] = true;
                        area++;
                        int[] temp2 = {nx, ny};
                        deque.add(temp2);
                    }
                }
            }
        }
        return area;
    }
}