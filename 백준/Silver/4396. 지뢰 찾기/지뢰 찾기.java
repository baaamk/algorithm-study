import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] mine;
    static char[][] open;
    static char[][] ans;

    static int[] dr = {-1,-1,-1, 0,0, 1,1,1};
    static int[] dc = {-1, 0, 1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        mine = new char[n][n];
        open = new char[n][n];
        ans = new char[n][n];

        // 지뢰판 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                mine[i][j] = line.charAt(j);
            }
        }

        // 열림판 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                open[i][j] = line.charAt(j);
            }
        }

        boolean boom = false;

        // 기본 출력판은 '.'로 채움
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], '.');
        }

        // 열린 칸 처리 + 폭발 여부 체크
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (open[r][c] == 'x') {
                    if (mine[r][c] == '*') {
                        boom = true;
                    } else {
                        int cnt = countMinesAround(r, c);
                        ans[r][c] = (char) ('0' + cnt);
                    }
                }
            }
        }

        // 폭발했다면 모든 지뢰를 '*'로 표시
        if (boom) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (mine[r][c] == '*') {
                        ans[r][c] = '*';
                    }
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            sb.append(ans[r]).append('\n');
        }
        System.out.print(sb.toString());
    }

    static int countMinesAround(int r, int c) {
        int cnt = 0;
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (mine[nr][nc] == '*') cnt++;
            }
        }
        return cnt;
    }
}