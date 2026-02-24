import java.util.*;
import java.io.*;

class Main {

    static void rotateClockwise45(int[][] board, int n) {
    int mid = n / 2;
    int[][] next = new int[n][n];

    // 전체 복사 (회전하지 않는 부분 유지)
    for (int i = 0; i < n; i++) {
        next[i] = board[i].clone();
    }

    for (int i = 0; i < n; i++) {
        // 1. 주 대각선 -> 가운데 열
        next[i][mid] = board[i][i];
        // 2. 가운데 열 -> 부 대각선
        next[i][n - 1 - i] = board[i][mid];
        // 3. 부 대각선 -> 가운데 행
        next[mid][n - 1 - i] = board[i][n - 1 - i];
        // 4. 가운데 행 -> 주 대각선
        next[i][i] = board[mid][i];
    }

    // 결과 반영
    for (int i = 0; i < n; i++) {
        board[i] = next[i].clone();
    }
}

static void rotateCounterClockwise45(int[][] board, int n) {
    int mid = n / 2;
    int[][] next = new int[n][n];

    for (int i = 0; i < n; i++) {
        next[i] = board[i].clone();
    }

    for (int i = 0; i < n; i++) {
        // 1. 주 대각선 -> 가운데 행
        next[mid][i] = board[i][i];
        // 2. 가운데 행 -> 부 대각선
        next[n - 1 - i][i] = board[mid][i];
        // 3. 부 대각선 -> 가운데 열
        next[n - 1 - i][mid] = board[n - 1 - i][i];
        // 4. 가운데 열 -> 주 대각선
        next[i][i] = board[i][mid];
    }

    for (int i = 0; i < n; i++) {
        board[i] = next[i].clone();
    }
}

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int times = Math.abs(d) / 45;

            for (int t = 0; t < times; t++) {
                if (d > 0) {
                    rotateClockwise45(board, n);
                } else if (d < 0) {
                    rotateCounterClockwise45(board, n);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.write(board[i][j] + " ");
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}