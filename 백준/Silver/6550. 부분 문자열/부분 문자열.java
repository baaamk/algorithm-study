import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        while(true){
            String str = br.readLine();
            if(str == null){
                break;
            }
            st = new StringTokenizer(str);
            String a = st.nextToken();
            String b = st.nextToken();
            int i = 0;
            int j = 0;
            
            while(i < a.length() && j < b.length()){
                if(a.charAt(i) == b.charAt(j)){
                    i++;
                }
                j++;
            }
            
            if(i == a.length()){
                bw.write("Yes");
                bw.newLine();
            } else {
                bw.write("No");
                bw.newLine();
            }
            
        }
        bw.flush();
        bw.close();
    }
}