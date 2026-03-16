import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        //n의 자리수
        long[][] dp = new long[101][10];
        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }
        
        for(int i = 2; i <=n; i++){
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            
            for(int j = 1; j <= 8; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
            }
        }
        
        long sum = 0;
        for(int i = 0; i <= 9; i++){
            sum = (sum + dp[n][i]) % 1000000000;
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}