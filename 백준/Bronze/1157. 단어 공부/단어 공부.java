import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine().toUpperCase();
        
        int[] a = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            a[c - 'A'] ++;
        }
        
        int max = 0;
        char out = '?';
        
        for(int i = 0; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
                out = (char) (i + 'A');
            } else if(a[i] == max){
                out = '?';
            }
        }    
        
        bw.write(out);
        bw.flush();
        bw.close();

    }
}