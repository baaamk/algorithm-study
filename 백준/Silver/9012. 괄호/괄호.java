import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            Deque<Character> stack = new ArrayDeque<>();
            boolean d = true;
            String str = br.readLine();
             for(int j = 0; j < str.length(); j++){
                 
                 char a = str.charAt(j);
                 if(a == '('){
                     stack.push('(');
                 } else{
                     if(stack.isEmpty()){
                         d = false;
                         break;
                         
                     }
                     stack.pop();
                 }
             }
             if(d && stack.size() == 0){
                 bw.write("YES");
                 bw.newLine();
             } else {
                 bw.write("NO");
                 bw.newLine();
                 
             }
        }
        bw.flush();
        bw.close();
    }
}