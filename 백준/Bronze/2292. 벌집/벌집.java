import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int end = 1;
        int layer = 1;
        while(n > end){
            end += 6 * layer;
            layer++;
        }
        
        bw.write(String.valueOf(layer));
        bw.flush();
        bw.close();
        
    }
}