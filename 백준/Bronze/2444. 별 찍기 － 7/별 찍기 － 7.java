import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // 1 -> 1, 2-> 3
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n-i -1; j++){
                bw.write(" ");
            }
            for(int j = 0; j<2 * i + 1; j++){
                bw.write("*");
            }
            bw.newLine();
        }
        
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j<i+1; j++){
                bw.write(" ");
            }
            for(int j = 0; j< 2 * (n - i) - 3; j++){
                bw.write("*");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}