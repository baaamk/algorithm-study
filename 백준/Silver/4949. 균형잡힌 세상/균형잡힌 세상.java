import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }
            Deque<Character> small = new ArrayDeque<>();

            boolean okays = true;

            for(int i = 0; i < str.length(); i++){
                char a = str.charAt(i);
                if(a == '(' || a == '['){
                    small.push(a);
                } else if(a == ')'){
                    if(small.isEmpty() || small.peek() != '('){
                        okays = false;
                        break;
                    }
                    small.pop();
                } else if(a == ']'){
                    if(small.isEmpty() || small.peek() != '['){
                        okays = false;
                        break;
                    }
                    small.pop();
                }
            }
            if(okays && small.size() == 0){
                    bw.write("yes");
                    bw.newLine();
                } else {
                    bw.write("no");
                    bw.newLine();
                }
        }
        bw.flush();
        bw.close();
    }
}