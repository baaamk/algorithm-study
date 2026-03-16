import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            
            Long[] a = new Long[101];
            a[1] = 1L;
            a[2] = 1L;
            a[3] = 1L;
            a[4] = 2L;
            for(int i = 5; i <= n; i++){
                a[i] = a[i - 2] + a[i - 3];
            }
            
            bw.write(a[n] + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}