import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int count = n;
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                count--;
                continue;
            }
            for(int j = 2; j < a; j++){
                if(a % j == 0){
                    count--;
                    break;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}