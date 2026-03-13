import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[301];
        int[][] d = new int[301][2];
        for(int i = 1; i <= n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        
        d[1][0] = stair[1];
        d[1][1] = 0;
        d[2][0] = stair[2];
        d[2][1] = stair[1] + stair[2];
        
        for(int i = 3; i <= n; i++){
            d[i][0] = Math.max(d[i - 2][1], d[i-2][0]) + stair[i];
            d[i][1] = d[i - 1][0] + stair[i];
        }
        bw.write(Math.max(d[n][0], d[n][1])+"");
        bw.flush();
        bw.close();
    }
}