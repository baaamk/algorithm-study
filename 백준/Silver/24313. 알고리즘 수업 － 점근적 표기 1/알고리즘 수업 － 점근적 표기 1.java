import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a1 = Long.parseLong(st.nextToken());
        long a2 = Long.parseLong(st.nextToken());
        
        long c = Long.parseLong(br.readLine());
        long n0 = Long.parseLong(br.readLine());
        
        if(isTrue(a1, a2, c, n0)){
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();

    }
            
        private static boolean isTrue(long a1, long a2, long c, long n0){
            return a1 * n0 + a2 <= c * n0 && (a1 <= c);
        }
}