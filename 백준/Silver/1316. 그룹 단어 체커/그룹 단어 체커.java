import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            //연속단어 판별법 abba??
            boolean[] a = new boolean[26];
            int prev = 0;
            boolean result = true;
            
            for(int j = 0; j < str.length(); j++){
                char b = str.charAt(j);
                if(prev != b){
                    if(a[b - 'a']){
                        result = false;
                        break;
                    }
                    a[b - 'a'] = true;
                    prev = b;
                }
            }
            if(result) {
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}