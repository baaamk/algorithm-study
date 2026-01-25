import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n/5; i ++){
            for(int j = 0; j <= n/3; j++){
                if(i * 5 + j * 3 == n){
                    min = Math.min(min, i + j);
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            bw.write("-1");
        } else{
            bw.write(min+"");
        }
        bw.flush();
        bw.close();
    }
}