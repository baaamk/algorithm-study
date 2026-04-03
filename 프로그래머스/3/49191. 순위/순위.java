import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // 1. 승패 관계를 저장할 인접 행렬 (또는 리스트)
        // win[i][j] : i번 선수가 j번 선수를 이겼으면 true
        boolean[][] win = new boolean[n + 1][n + 1];

        for (int[] r : results) {
            win[r[0]][r[1]] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        // 3. 각 선수마다 승패가 확정된 상대가 n-1명인지 확인
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                // 내가 이겼거나, 내가 졌거나 (상대 j가 나를 이겼거나)
                if (win[i][j] || win[j][i]) {
                    count++;
                }
            }
            if (count == n - 1) answer++;
        }

        return answer;
    }
}