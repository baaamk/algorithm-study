import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[1001];
        int[][] c = new int[1001][2];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            c[i][0] = days;
            c[i][1] = money;
        }
        
        for (int i = n; i >= 1; i--) {
            if (i + c[i][0] - 1 <= n) {
                dp[i] = Math.max(dp[i + 1], c[i][1] + dp[i + c[i][0]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        int max = 0;
        for(int a : dp){
            max = Math.max(max, a);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}