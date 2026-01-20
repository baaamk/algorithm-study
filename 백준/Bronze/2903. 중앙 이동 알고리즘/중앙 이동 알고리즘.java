import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        for(int i = 0; i < n; i++){
            if(i == 0){
                a = 2;
            }
            a = 2*a - 1;
        }
        
        bw.write(String.valueOf(a * a));
        bw.flush();
        bw.close();
    }
}