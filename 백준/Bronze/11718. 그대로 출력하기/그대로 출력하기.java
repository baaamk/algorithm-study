import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true){
            String str = br.readLine();
            if(str == null){
                break;
            }
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}