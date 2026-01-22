import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int result = 0;
        for (int j = 1; j <= n; j++){
            int sum = j;
            int m = j;
            int amount = String.valueOf(m).length();
            for(int i = 0; i < amount; i++){
                sum += Integer.parseInt(String.valueOf(String.valueOf(m).charAt(i)));
            }
            if(sum == n){
                result = j;
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        
    }
}