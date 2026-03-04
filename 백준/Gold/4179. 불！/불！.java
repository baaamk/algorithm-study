import java.io.*;
import java.util.*;

class Main{
    static int n, m;
    static char[][] board;
    static int[][] distF;
    static int[][] distJ;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        distF = new int[n][m];
        distJ = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(distF[i], -1);
            Arrays.fill(distJ[i], -1);
        }

        Deque<int[]> fire = new ArrayDeque<>();
        Deque<int[]> ji = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = str.charAt(j);

                if(board[i][j]=='F'){
                    fire.add(new int[]{i,j});
                    distF[i][j] = 0;
                }

                if(board[i][j]=='J'){
                    ji.add(new int[]{i,j});
                    distJ[i][j] = 0;
                }
            }
        }

        // 불 BFS
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

        // 지훈 BFS
        while(!ji.isEmpty()){
            int[] cur = ji.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0 || nc<0 || nr>=n || nc>=m){
                    bw.write(distJ[r][c] + 1 + "");
                    bw.flush();
                    bw.close();
                    return;
                }

                if(board[nr][nc]=='#') continue;
                if(distJ[nr][nc]>=0) continue;

                if(distF[nr][nc] != -1 && distF[nr][nc] <= distJ[r][c] + 1) continue;

                distJ[nr][nc] = distJ[r][c] + 1;
                ji.add(new int[]{nr,nc});
            }
        }

        bw.write("IMPOSSIBLE");
        bw.flush();
        bw.close();
    }
}