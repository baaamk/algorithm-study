import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2; i++){
            String str = st.nextToken();
            String a = String.valueOf(str.charAt(2)) + String.valueOf(str.charAt(1)) + String.valueOf(str.charAt(0));
            if(Integer.parseInt(a) >= max){
                max = Integer.parseInt(a);
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}