import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(String a : arr){
            str = str.replace(a,"0"); //해당하면 0으로 변경
        }
        bw.write(String.valueOf(str.length()));
        bw.flush();
        bw.close();
        
        
    }
}