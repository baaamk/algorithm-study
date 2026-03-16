import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[1001];
        int[] dp = new int[1001];

        for (int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        

        for(int i = 1; i <= n; i++){
            dp[i] = 1;
            
            for(int j = 1; j <i; j++){
                if(a[j]<a[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    
                }
            }
        }
        int max = 0;
        for(int i = 1; i<=n; i++){
            max = Math.max(max, dp[i]);
        }
        
        bw.write(max +"");
        bw.flush();
        bw.close();
    }
}