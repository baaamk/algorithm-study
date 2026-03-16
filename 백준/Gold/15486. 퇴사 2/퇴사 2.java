import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[1500002][2];
        int[] dp = new int[1500002];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken()); //기간
            a[i][1] = Integer.parseInt(st.nextToken()); //금액
        }
        
        
        
        for(int i = n; i >= 1; i--){
            if(i + a[i][0] - 1 <= n){
                dp[i] = Math.max(dp[i + 1], a[i][1] + dp[i + a[i][0]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        
        bw.write(dp[1] + "");
        bw.flush();
        bw.close();
    }
}