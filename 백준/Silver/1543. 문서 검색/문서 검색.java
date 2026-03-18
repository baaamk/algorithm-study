import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        
        String target = br.readLine();
        
        int count = 0;
        
        int i = 0;
        while(i <= str.length() - target.length()){
            boolean match = true;

            for(int j = 0; j < target.length(); j++){
                if(str.charAt(i + j) != target.charAt(j)){
                    match = false;
                    break;
                }
            }

            if(match){
                count++;
                i += target.length(); // 겹치지 않게 점프
            } else {
                i++;
            }
        }
        
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}