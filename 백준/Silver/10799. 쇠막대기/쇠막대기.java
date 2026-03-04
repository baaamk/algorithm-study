import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Deque<Character> deque = new ArrayDeque<>();
        int ans = 0;
        String str = br.readLine();
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                deque.push('(');
            } else {
                deque.pop();
                if(str.charAt(i - 1) == '('){
                ans += deque.size();
                } else {
                    ans += 1;
                }
            }
        }
        bw.write(ans+ "");
        bw.flush();
        bw.close();
    }
}