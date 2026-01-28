import java.util.*;
import java.io.*;

class Main{
    public static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        isPrime(m);
        for(int i = n; i <= m; i++){
            if(!arr[i]){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        
    }
    
    static void isPrime(int m){
        arr = new boolean[m + 1];
        if(m < 2){
            return;
        }
        arr[0] = arr[1] = true;
        
        for(int i = 2; i <= Math.sqrt(m); i++){
            if(arr[i]){
                continue;
            }
            
            for(int j = i * i; j < arr.length; j+= i){
                arr[j] = true;
            }
        }
    }
}