import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for(int i =0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String m1 = st.nextToken();
            String m2 = st.nextToken();
            if(set.contains(m1)){
                set.add(m2);
            } else if(set.contains(m2)){
                set.add(m1);
            }
        }
        bw.write(set.size() + "");
        bw.flush();
        bw.close();
        
    }
}