import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] col = new int[26];
        int[] row = new int[26];

        int[][] visit = new int[5][5];

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < 5; j++){
                int n = Integer.parseInt(st.nextToken());
                row[n] = i;
                col[n] = j;
            }
        }

        int callCount = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int x = Integer.parseInt(st.nextToken());
                callCount++;

                int r = row[x];
                int c = col[x];
                visit[r][c] = 1;

                if (bingoCount(visit) >= 3) {
                    System.out.println(callCount);
                    return;
                }
            }
        }
    }

    static int bingoCount(int[][] visit) {

        int count = 0;

        // 가로
        for (int r = 0; r < 5; r++) {
            boolean ok = true;
            for (int c = 0; c < 5; c++) {
                if (visit[r][c] == 0) { ok = false; break; }
            }
            if (ok) count++;
        }

        // 세로
        for (int c = 0; c < 5; c++) {
            boolean ok = true;
            for (int r = 0; r < 5; r++) {
                if (visit[r][c] == 0) { ok = false; break; }
            }
            if (ok) count++;
        }

        // 대각선 \
        boolean ok1 = true;
        for (int i = 0; i < 5; i++) {
            if (visit[i][i] == 0) { ok1 = false; break; }
        }
        if (ok1) count++;

        // 대각선 /
        boolean ok2 = true;
        for (int i = 0; i < 5; i++) {
            if (visit[i][4 - i] == 0) { ok2 = false; break; }
        }
        if (ok2) count++;

        return count;
    }
}