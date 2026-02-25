import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int nextPush = 1;

        for (int i = 0; i < n; i++) {

            int target = Integer.parseInt(br.readLine());

            // target까지 push (필요한 만큼만)
            while (nextPush <= target) {
                stack.push(nextPush);
                nextPush++;
                sb.append("+\n");
            }

            // top이 target이면 pop
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.print("NO");
                return;
            }
        }

        System.out.print(sb.toString());
    }
}