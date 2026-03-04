import java.util.*;
import java.io.*;

class Main{
    static int n;
    static char[][] board;
    static boolean[][] visit;
    static boolean[][] visit2;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = s.charAt(j);
            }
        }

        visit = new boolean[n][n];
        visit2 = new boolean[n][n];

        int normal = 0;
        int weak = 0;

        // 일반
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j]){
                    bfsNormal(i, j);
                    normal++;
                }
            }
        }

        // 적록색약
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit2[i][j]){
                    bfsWeak(i, j);
                    weak++;
                }
            }
        }

        bw.write(normal + " " + weak);
        bw.flush();
        bw.close();
    }

    static void bfsNormal(int r, int c){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visit[r][c] = true;

        char color = board[r][c];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                    if(!visit[nr][nc] && board[nr][nc] == color){
                        visit[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    static void bfsWeak(int r, int c){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visit2[r][c] = true;

        char start = board[r][c];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                    if(visit2[nr][nc]) continue;

                    // 적록색약 규칙: R과 G는 같은 색으로 취급
                    if(start == 'B'){
                        if(board[nr][nc] == 'B'){
                            visit2[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    } else { // start가 R 또는 G
                        if(board[nr][nc] == 'R' || board[nr][nc] == 'G'){
                            visit2[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
    }
}