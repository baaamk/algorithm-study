import java.util.*;

class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1}); // r, c, 거리
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int dist = now[2];

            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (!visited[nr][nc] && maps[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }

        return -1; // 못 가는 경우
    }
}