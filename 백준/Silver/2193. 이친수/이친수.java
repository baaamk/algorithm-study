import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        long[][] a = new long[91][2];
        
        
        a[1][0] = 0;
        a[1][1] = 1;
        for(int i = 2; i <= n; i++){
            a[i][0] = a[i-1][0] + a[i-1][1];
            a[i][1] = a[i-1][0];
        }
        
        bw.write(a[n][0] + a[n][1] + "");
        bw.flush();
        bw.close();
    }
}