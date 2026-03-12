import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                } else if (str.charAt(j) == '<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                } else if(str.charAt(j) == '>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                } else {
                    left.push(str.charAt(j));
                }
            }
            while(!left.isEmpty()){
                right.push(left.pop());
            }
        
            while(!right.isEmpty()){
                bw.write(right.pop());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
}