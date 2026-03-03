import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long a;
    static long b;
    static long c;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long result = cal(a, b, c);
        bw.write(result + "");
        bw.flush();
    }

    static long cal(long a, long b, long c) {
        if (b == 0) return 1;
        if (b == 1) return a % c;

        long half = cal(a, b / 2, c);

        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return ((half * half) % c * a) % c;
        }
    }
}