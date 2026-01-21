import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;
        int max = Math.max(a, Math.max(b, c));

        // 삼각형이 아니면 max를 줄여서 max = (sum - max) - 1
        if (max >= sum - max) {
            sum = (sum - max) + (sum - max - 1);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}