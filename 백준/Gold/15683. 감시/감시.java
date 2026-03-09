import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] board;
    static int[][] watched;
    static List<int[]> cctvs = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        watched = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] >= 1 && board[i][j] <= 5) {
                    cctvs.add(new int[]{i, j});
                }
            }
        }

        backTrack(0);

        System.out.println(min);
    }

    static void backTrack(int depth) {
        if (depth == cctvs.size()) {
            min = Math.min(min, countBlindSpot());
            return;
        }

        int[] cur = cctvs.get(depth);
        int r = cur[0];
        int c = cur[1];
        int type = board[r][c];

        if (type == 1) {
            for (int d = 0; d < 4; d++) {
                watch(r, c, d, 1);
                backTrack(depth + 1);
                watch(r, c, d, -1);
            }
        } else if (type == 2) {
            for (int d = 0; d < 2; d++) {
                watch(r, c, d, 1);
                watch(r, c, d + 2, 1);
                backTrack(depth + 1);
                watch(r, c, d, -1);
                watch(r, c, d + 2, -1);
            }
        } else if (type == 3) {
            for (int d = 0; d < 4; d++) {
                watch(r, c, d, 1);
                watch(r, c, (d + 1) % 4, 1);
                backTrack(depth + 1);
                watch(r, c, d, -1);
                watch(r, c, (d + 1) % 4, -1);
            }
        } else if (type == 4) {
            for (int d = 0; d < 4; d++) {
                watch(r, c, d, 1);
                watch(r, c, (d + 1) % 4, 1);
                watch(r, c, (d + 2) % 4, 1);
                backTrack(depth + 1);
                watch(r, c, d, -1);
                watch(r, c, (d + 1) % 4, -1);
                watch(r, c, (d + 2) % 4, -1);
            }
        } else if (type == 5) {
            for (int d = 0; d < 4; d++) {
                watch(r, c, d, 1);
            }
            backTrack(depth + 1);
            for (int d = 0; d < 4; d++) {
                watch(r, c, d, -1);
            }
        }
    }

    static void watch(int r, int c, int dir, int delta) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        while (nr >= 0 && nr < n && nc >= 0 && nc < m) {
            if (board[nr][nc] == 6) {
                break;
            }

            if (board[nr][nc] == 0) {
                watched[nr][nc] += delta;
            }

            nr += dr[dir];
            nc += dc[dir];
        }
    }

    static int countBlindSpot() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && watched[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}