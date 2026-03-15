import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[1001];
        
        a[1] = 1;
        a[2] = 3;
        a[3] = 5;
        for(int i = 4; i <= n; i++){

            a[i] = (a[i - 1] + a[i - 2]*2) % 10007;

        }
        
        bw.write(a[n] + "");
        bw.flush();
        bw.close();
    }
}