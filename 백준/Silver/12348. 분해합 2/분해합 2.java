import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long s = Long.parseLong(br.readLine());
        long answer = 0;
        //s = 어떤 숫자 + 그 숫자의 자리수 합.
        long start = s - 9L * String.valueOf(s).length();
        if(start < 1){
            start = 1;
        }
        
        for(long i = start; i <= s; i++){
            long sum = i;
            long x = i;
            while(x > 0){
                sum += (x % 10);
                x /= 10;
            }
            if(sum == s){
                answer = i;
                break;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}