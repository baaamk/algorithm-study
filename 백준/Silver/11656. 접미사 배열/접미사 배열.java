import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        String[] arr = new String[str.length()];
        for(int i = 0; i < str.length(); i++){
            String s = str.substring(i, str.length());
            arr[i] = s;
        }
        
        Arrays.sort(arr);
        
        for(String a : arr){
            bw.write(a);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}