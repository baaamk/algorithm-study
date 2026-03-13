import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] h = new int[1001][3];
        int[][] p = new int[1001][3];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            h[i][0] = Integer.parseInt(st.nextToken());
            h[i][1] = Integer.parseInt(st.nextToken());
            h[i][2] = Integer.parseInt(st.nextToken());
        }
        
        p[2][0] = Math.min(h[1][1] + h[2][0], h[1][2] + h[2][0]);
        p[2][1] = Math.min(h[1][0] + h[2][1], h[1][2] + h[2][1]);
        p[2][2] = Math.min(h[1][0] + h[2][2], h[1][1] + h[2][2]);


        for(int i = 3; i <= n; i++){
            p[i][0] = Math.min(p[i-1][1] + h[i][0], p[i-1][2] + h[i][0]);
            p[i][1] = Math.min(p[i-1][0] + h[i][1], p[i-1][2] + h[i][1]);
            p[i][2] = Math.min(p[i-1][0] + h[i][2], p[i-1][1] + h[i][2]);
        }
        bw.write(Math.min(p[n][0],Math.min(p[n][1],p[n][2]))+"");
        bw.flush();
        bw.close();
    }
}