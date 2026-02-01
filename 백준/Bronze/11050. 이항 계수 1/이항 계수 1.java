import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int total = 1;
        for(int i = 1; i <= n; i++){
            total *= i;
        }
        int total2 = 1;
        for(int i = 1; i <= m; i++){
            total2 *= i;
        }
        int k = n-m;
        int total3 = 1;
        for(int i = 1; i <= k; i++){
            total3 *= i;
        }
        
        int result = total / (total2 * total3);
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}