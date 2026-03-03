import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (int x : dq) {
                if (x == target) break;
                idx++;
            }

            if (idx <= dq.size() / 2) {
                // 왼쪽 회전
                while (dq.peek() != target) {
                    dq.addLast(dq.pollFirst());
                    count++;
                }
            } else {
                // 오른쪽 회전
                while (dq.peek() != target) {
                    dq.addFirst(dq.pollLast());
                    count++;
                }
            }

            dq.pollFirst(); // 제거
        }

        System.out.println(count);
    }
}