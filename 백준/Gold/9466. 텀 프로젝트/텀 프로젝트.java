import java.io.*;
import java.util.*;

class Main {

    static int[] arr;
    static int[] state;

    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            state[cur] = start;

            int next = arr[cur];

            // 이번 탐색에서 이미 방문 → 사이클 발견
            if (state[next] == start) {
                while (state[next] != CYCLE_IN) {
                    state[next] = CYCLE_IN;
                    next = arr[next];
                }
                return;
            }

            // 이전 탐색에서 방문
            if (state[next] != NOT_VISITED) return;

            q.add(next);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            state = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (state[i] == NOT_VISITED) bfs(i);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != CYCLE_IN) cnt++;
            }

            System.out.println(cnt);
        }
    }
}