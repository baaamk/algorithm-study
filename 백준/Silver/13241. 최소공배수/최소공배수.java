import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long gcd = gcd(a,b);
        long lcm = (a / gcd) * b;
        
        bw.write(lcm + "");
        bw.flush();
        bw.close();
    }
    
    static long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}