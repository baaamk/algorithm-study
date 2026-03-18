import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        int[] S = new int[n];
        int[] B = new int[n];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        long min = Long.MAX_VALUE;
        for(int i = 1; i < (1 << n); i++){
            long s = 1;
            long b = 0;
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    s *= S[j];
                    b += B[j];
                }
            }
            min = Math.min(min,Math.abs(s - b));
        }
        bw.write(min +"");
        bw.flush();
        bw.close();
    }
}