import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 행
    int m = Integer.parseInt(st.nextToken());  // 열
    int r = Integer.parseInt(st.nextToken());  // 회전 횟수

    int[][] board = new int[n][m];

    for (int i = 0; i < n; i++) {

        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < m; j++) {

            board[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    int count = Math.min(n, m) / 2;   // 레이어 개수

    for (int i = 0; i < r; i++) {     // 회전 횟수만큼 반복

        for (int j = 0; j < count; j++) {   // 각 레이어

            int temp = board[j][j];

            for (int k = j + 1; k < m - j; k++) {

                board[j][k - 1] = board[j][k];
            }

            for (int k = j + 1; k < n - j; k++) {

                board[k - 1][m - 1 - j] = board[k][m - 1 - j];
            }

            for (int k = m - 2 - j; k >= j; k--) {

                board[n - 1 - j][k + 1] = board[n - 1 - j][k];
            }

            for (int k = n - 2 - j; k >= j; k--) {

                board[k + 1][j] = board[k][j];
            }

            board[j + 1][j] = temp;
        }
    }

    for (int i = 0; i < n; i++) {

        for (int j = 0; j < m; j++) {

            System.out.print(board[i][j] + " ");
        }

        System.out.println();
    }
}
}
