import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long n = Integer.parseInt(br.readLine());
        
        // n 은 몇번째 줄인지를 의미하기도 한다. 
        bw.write(String.valueOf(4L * n));
        bw.flush();
        bw.close();
    }
}