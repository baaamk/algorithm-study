import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        int m = ~n + 1;
        
        int diff = n ^ m;
        
        bw.write(Integer.bitCount(diff) + "");
        bw.flush();
        bw.close();
    }
}