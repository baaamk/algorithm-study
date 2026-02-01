import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];

        long answer = 0;
        S[0] = scanner.nextInt();

        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) {
                answer ++;
            }
            C[remainder]++;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}
