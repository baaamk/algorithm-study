import java.util.*;
import java.io.*;

class Main{
    static int get(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return get(n - 1) + get(n - 2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        bw.write(get(n) + "");
        bw.flush();
        bw.close();
    }
}