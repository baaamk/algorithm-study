import java.io.*;
import java.util.*;

class Main {
    static class Balloon {
        int idx;
        int move;
        Balloon(int idx, int move) {
            this.idx = idx;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Deque<Balloon> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while (!dq.isEmpty()) {
            Balloon cur = dq.pollFirst();     // 풍선 터뜨리기
            bw.write(String.valueOf(cur.idx));
            bw.newLine();

            if (dq.isEmpty()) break;

            int step = cur.move;

            if (step > 0) {
                // 이미 하나 뽑았으니 step-1 만큼만 회전
                for (int i = 0; i < step - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                // 음수면 왼쪽으로 |step|만큼 => 뒤에서 앞으로 가져오기
                for (int i = 0; i < -step; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        bw.flush();
        bw.close();
    }
}