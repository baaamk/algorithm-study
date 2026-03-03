import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {

            String str = br.readLine();
            int m = Integer.parseInt(br.readLine());
            String str2 = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();

            if (m > 0) {
                str2 = str2.substring(1, str2.length() - 1);
                String[] arr = str2.split(",");
                for (String token : arr) {
                    deque.addLast(Integer.parseInt(token));
                }
            }

            boolean error = false;
            int a = -1; // -1 앞, 1 뒤

            for (int i = 0; i < str.length(); i++) {

                char cmd = str.charAt(i);

                if (cmd == 'R') {
                    a *= -1;
                } 
                else if (cmd == 'D') {

                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (a == -1) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (error) {
                bw.write("error");
            } 
            else {
                bw.write("[");
                while (!deque.isEmpty()) {

                    if (a == -1) {
                        bw.write(String.valueOf(deque.pollFirst()));
                    } else {
                        bw.write(String.valueOf(deque.pollLast()));
                    }

                    if (!deque.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}