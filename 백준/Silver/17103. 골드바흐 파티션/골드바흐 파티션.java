import java.util.*;
import java.io.*;

class Main{
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        //2보다 큰 짝수가 두 소수의 합으로 이루어 지는 개수. 반대는 같은 것.
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            isPrime(a);
            int count = 0;
            for(int j = 2; j <= a / 2; j++){
                if(!prime[j] && !prime[a - j]){
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }
    
    static void isPrime(int a){
        prime = new boolean[a + 1];
        if(a < 2){
            return;
        }
        
        prime[0] = prime[1] = true;
        
        for(int i = 2; i <= Math.sqrt(a); i++){
            if(prime[i]){
                continue;
            }
            
            for(int j = i * i; j < prime.length; j+= i){
                prime[j] = true;
            }
        }
    }
}