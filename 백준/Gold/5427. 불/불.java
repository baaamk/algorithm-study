import java.util.*;
import java.io.*;

class Main{
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n,m;
    static char[][] board;
    static int[][] distF;
    static int[][] distS;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            distF = new int[n][m];
            distS = new int[n][m];
            
            board = new char[n][m];
            for(int i=0;i<n;i++){
                Arrays.fill(distF[i], -1);
                Arrays.fill(distS[i], -1);
            }
            
            Deque<int[]> fire = new ArrayDeque<>();
            Deque<int[]> sung = new ArrayDeque<>();
            
            for(int i=0;i<n;i++){
                String str = br.readLine();
                for(int j=0;j<m;j++){
                    board[i][j] = str.charAt(j);

                    if(board[i][j]=='*'){
                        fire.add(new int[]{i,j});
                        distF[i][j] = 0;
                    }

                    if(board[i][j]=='@'){
                        sung.add(new int[]{i,j});
                        distS[i][j] = 0;
                    }
                }
            }

            bfs(fire, sung);
            
            
    }
    bw.flush();
    bw.close();
        
}
    static void bfs(Deque<int[]> fire, Deque<int[]> sung) throws IOException {
        // 불 BFS
        while(!fire.isEmpty()){
            int[] cur = fire.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                if(board[nr][nc]=='#') continue;
                if(distF[nr][nc]>=0) continue;

                distF[nr][nc] = distF[r][c] + 1;
                fire.add(new int[]{nr,nc});
            }
        }

        //  BFS
        while(!sung.isEmpty()){
            int[] cur = sung.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0 || nc<0 || nr>=n || nc>=m){
                    bw.write(distS[r][c] + 1 + "");
                    bw.newLine();
                    return;
                }

                if(board[nr][nc]=='#') continue;
                if(distS[nr][nc]>=0) continue;

                if(distF[nr][nc] != -1 && distF[nr][nc] <= distS[r][c] + 1) continue;

                distS[nr][nc] = distS[r][c] + 1;
                sung.add(new int[]{nr,nc});
            }
        }

        bw.write("IMPOSSIBLE");
        bw.newLine();
        }
    }
