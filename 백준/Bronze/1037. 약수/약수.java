import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a > max){
                max = a;
            }
            if(a < min){
                min = a;
            }
        }
        
        bw.write(String.valueOf(min * max));
        bw.flush();
        bw.close();
        
    }
}