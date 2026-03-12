import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String a = br.readLine();
        int n = Integer.parseInt(br.readLine());
        char b = a.charAt(n - 1);
        
        bw.write(b);
        bw.flush();
        bw.close();
        
        
    }
}