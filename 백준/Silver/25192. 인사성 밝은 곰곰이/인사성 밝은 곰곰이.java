import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                set.clear();
            } else if(!set.contains(str)){
                set.add(str);
                count++;
            }
            
        }
        bw.write(count +"");
        bw.flush();
        bw.close();
        
    }
}