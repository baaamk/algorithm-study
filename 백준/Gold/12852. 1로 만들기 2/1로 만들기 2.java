import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        a[1] = 0;
        
        for(int i = 2; i <= n; i++){
            a[i] = a[i - 1] + 1;
            b[i] = i - 1;
            
            if(i % 2 == 0 && a[i] > a[i/2] + 1){
                a[i] = a[i/2] + 1;
                b[i] = i / 2;
            }
            if(i % 3 == 0 && a[i] > a[i/3] + 1){
                a[i] = a[i/3] + 1;
                b[i] = i / 3;
            }
        }
        

        bw.write(a[n] + "");
        bw.newLine();
        int cur = n;
        while(cur != 0){
            bw.write(cur + " ");
            cur = b[cur];
        }
        bw.flush();
        bw.close();
    }
}