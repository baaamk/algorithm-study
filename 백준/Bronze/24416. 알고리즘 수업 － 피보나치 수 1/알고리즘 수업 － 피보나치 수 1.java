    import java.util.*;
import java.io.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] arr;
    static long count1 = 0;
    static long count2 = 0;
    
    static long fib(int n) {
        if(n == 1 || n == 2){
            count1++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }
    
    static long fibonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        for(int i = 2; i <= n; i++){
            if(i >= 3){
                count2++;
            }
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
    
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];
        
        arr[0] = 0;
        arr[1] = 1;
        fib(n);
        fibonacci(n);
        bw.write(count1 + " " + count2);
        bw.flush();
        bw.close();
        
    }
}