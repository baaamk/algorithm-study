import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board1 = new int[10][10];
    static int[][] board2 = new int[10][10];

    static int[] dx = {1, 0, -1, 0}; // 남 동 북 서
    static int[] dy = {0, 1, 0, -1};

    static List<int[]> cctv = new ArrayList<>();

    static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    // 감시선 뻗기
    static void upd(int x, int y, int dir) {
        dir %= 4;

        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (OOB(x, y) || board2[x][y] == 6) {
                return;
            }

            if (board2[x][y] != 0) {
                continue;
            }

            board2[x][y] = 7;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int mn = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {

                board1[i][j] = Integer.parseInt(st.nextToken());

                if (board1[i][j] != 0 && board1[i][j] != 6) {
                    cctv.add(new int[]{i, j});
                }

                if (board1[i][j] == 0) {
                    mn++;
                }
            }
        }

        int totalCase = 1 << (2 * cctv.size()); // 4^cctv

        for (int tmp = 0; tmp < totalCase; tmp++) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board1[i][j];
                }
            }

            int brute = tmp;

            for (int i = 0; i < cctv.size(); i++) {

                int dir = brute % 4;
                brute /= 4;

                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];

                int type = board1[x][y];

                if (type == 1) {
                    upd(x, y, dir);
                }

                else if (type == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                }

                else if (type == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                }

                else if (type == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                }

                else if (type == 5) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }

            int val = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board2[i][j] == 0) {
                        val++;
                    }
                }
            }

            mn = Math.min(mn, val);
        }

        System.out.println(mn);
    }
}