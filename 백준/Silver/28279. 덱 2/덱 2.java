import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1: { // push_front
                    int x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                }
                case 2: { // push_back
                    int x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                }
                case 3: { // pop_front
                    if (dq.isEmpty()) bw.write("-1");
                    else bw.write(String.valueOf(dq.pollFirst()));
                    bw.newLine();
                    break;
                }
                case 4: { // pop_back
                    if (dq.isEmpty()) bw.write("-1");
                    else bw.write(String.valueOf(dq.pollLast()));
                    bw.newLine();
                    break;
                }
                case 5: { // size
                    bw.write(String.valueOf(dq.size()));
                    bw.newLine();
                    break;
                }
                case 6: { // empty
                    bw.write(dq.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                }
                case 7: { // front
                    if (dq.isEmpty()) bw.write("-1");
                    else bw.write(String.valueOf(dq.peekFirst()));
                    bw.newLine();
                    break;
                }
                case 8: { // back
                    if (dq.isEmpty()) bw.write("-1");
                    else bw.write(String.valueOf(dq.peekLast()));
                    bw.newLine();
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}