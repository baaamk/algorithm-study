import java.io.*;
import java.util.*;

public class Main {

    static char[][] board = new char[5][5];
    static boolean[][] selected = new boolean[5][5];
    static int answer = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        comb(0, 0, 0, 0);

        System.out.println(answer);
    }

    static void comb(int depth, int start, int sCount, int yCount) {
        if (yCount >= 4) {
            return;
        }

        if (sCount + (7 - depth) < 4) {
            return;
        }

        if (depth == 7) {
            if (isConnected()) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;

            selected[r][c] = true;

            if (board[r][c] == 'S') {
                comb(depth + 1, i + 1, sCount + 1, yCount);
            } else {
                comb(depth + 1, i + 1, sCount, yCount + 1);
            }

            selected[r][c] = false;
        }
    }

    static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();

        int sr = -1;
        int sc = -1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (selected[i][j]) {
                    sr = i;
                    sc = j;
                    break;
                }
            }
            if (sr != -1) {
                break;
            }
        }

        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
                    continue;
                }

                if (!selected[nr][nc]) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                count++;
            }
        }

        return count == 7;
    }
}