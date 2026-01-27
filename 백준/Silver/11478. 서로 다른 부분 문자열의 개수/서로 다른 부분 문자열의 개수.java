import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Set<String> set = new HashSet<>();
        String a = br.readLine();
        int len = a.length();
        int pro = 1;
        while(pro <= len) {
            for(int i = 0; i < len - pro + 1; i++){
                set.add(a.substring(i, i+pro));
            }
            pro++;
        }
        bw.write(set.size()+"");
        bw.flush();
        bw.close();
    }
}