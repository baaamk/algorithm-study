import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        int[] s = new int[1001];
        s[1] = 1;
        s[2] = 2;
        for(int i = 3; i <= n; i++){
            s[i] = (s[i -2] + s[i - 1]) % 10007;
        }
        bw.write(s[n] + "");
        bw.flush();
        bw.close();
        
    }
}