import java.util.*;
import java.io.*;

class Main {
    static int n, l, r;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }

    static boolean bfs(int sr, int sc) {
        Deque<int[]> queue = new ArrayDeque<>();
        List<int[]> union = new ArrayList<>();

        queue.add(new int[]{sr, sc});
        union.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        int sum = board[sr][sc];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r0 = cur[0];
            int c0 = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r0 + dr[d];
                int nc = c0 + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                int diff = Math.abs(board[r0][c0] - board[nr][nc]);
                if (diff < l || diff > r) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
                union.add(new int[]{nr, nc});
                sum += board[nr][nc];
            }
        }

        if (union.size() == 1) {
            return false;
        }

        int newPeople = sum / union.size();

        for (int[] pos : union) {
            board[pos[0]][pos[1]] = newPeople;
        }

        return true;
    }
}
