import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            String st = br.readLine();
            char a = st.charAt(0);
            char b = st.charAt(st.length() - 1);
            bw.write(a);
            bw.write(b);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}