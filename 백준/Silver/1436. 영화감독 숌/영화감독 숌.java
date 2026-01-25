import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int num = 665;
        int count = 0;
        while(count < n){
            num ++;
            if(String.valueOf(num).contains("666")){
                count ++;
            }
        }
        
        bw.write(num + "");
        bw.flush();
        bw.close();
    }
}