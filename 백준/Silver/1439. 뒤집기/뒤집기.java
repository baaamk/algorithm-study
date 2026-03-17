import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int[] arr = new int[s.length() +1];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i) - '0';
        }
        arr[s.length()] = 2;
        
        int z = 0;
        int o = 0;
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] != arr[i + 1]){
                if(arr[i] == 0){
                    z++;
                } else{
                    o++;
                }
            }
        }
        
        int answer = Math.min(z,o);
        
        bw.write(answer+"");
        bw.flush();
        bw.close();
        
    }
}