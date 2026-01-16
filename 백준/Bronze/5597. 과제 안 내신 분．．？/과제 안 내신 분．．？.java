import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] a = new boolean[30];
        for(int i = 0; i < 28; i++){
            int n = Integer.parseInt(br.readLine());
            a[n - 1] = true;
        }
        
        for(int i = 0; i< 30; i++){
            if(a[i] == false){
                bw.write(String.valueOf(1+i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}