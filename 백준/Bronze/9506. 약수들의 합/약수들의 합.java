import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == -1){
                break;
            }
            
            List<Integer> a = new ArrayList<>();
            for(int i = 1; i < n; i++){
                if(n % i == 0){
                    a.add(i);
                }
            }
            
            int result = 0;
            for(int i = 0; i < a.size(); i++){
                result += a.get(i);
            }
            
            if(result == n){
                bw.write(String.valueOf(n));
                for(int i = 0; i < a.size(); i++){
                    if(i == 0){
                        bw.write(" = " + a.get(i));
                    } else {
                        bw.write(" + " + a.get(i));
                    }
                }
            } else {
                bw.write(n + " is NOT perfect.");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}