import java.util.*;
import java.io.*;

class Main{
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            int m = 2 * n;
            isPrime(m);
            
            int count = 0;
            for(int i = n + 1; i <= m; i++){
                if(!prime[i]){
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
            
        }
        
        bw.flush();
        bw.close();
        
    }
    
    static void isPrime(int m){
        prime = new boolean[m + 1];
        
        if(m < 2){
            return;
        }
        
        prime[0] = prime[1] = true;
        
        for(int i = 2; i <= Math.sqrt(m); i++){
            if(prime[i]){
                continue;
            }
            
            for(int j = i * i; j < prime.length; j+= i){
                prime[j] = true;
            }
            
        }
    }
}