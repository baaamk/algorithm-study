import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char ch = br.readLine().charAt(0);
        int n = (byte) ch;
        
        bw.write(String.valueOf(n));
        bw.flush();
        bw.close();
    }
}