import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int a = 1;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length() - i -1)){
                a = 0;
                break;
            }
        }
        bw.write(String.valueOf(a));
        bw.flush();
        bw.close();
    }
}