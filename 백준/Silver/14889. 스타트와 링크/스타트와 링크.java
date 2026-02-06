import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    static void combi(int idx, int count) {
        // 스타트팀 인원 N/2명 뽑으면 점수 계산
        if (count == N / 2) {
            calcDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;          // i를 스타트팀으로 선택
                combi(i + 1, count + 1);  // 다음 후보부터 계속 선택
                visit[i] = false;         // 되돌리기
            }
        }
    }

    static void calcDiff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start = start + S[i][j] + S[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link = link + S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        if (diff < min) {
            min = diff;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);

        bw.write(min + "");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}