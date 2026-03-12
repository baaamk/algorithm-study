import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int line = 1;
        int end = 1;
        while(end < n){
            line++;
            end += line;
        }
        
        int result = end - n;
        int num = 0;
        int mom = 0;
        if(line % 2 == 0){
            num = line - result;
            mom = 1 + result;
        } else {
            num = 1 + result;
            mom = line - result;
        }
        bw.write(num + "/" + mom);
        bw.flush();
        bw.close();
    }
}