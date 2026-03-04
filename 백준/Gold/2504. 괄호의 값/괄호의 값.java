import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Deque<Character> deque = new ArrayDeque<>();

        int answer = 0;
        int temp = 1;
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                deque.push('(');
                temp *= 2;

            } else if (ch == '['){
                deque.push('[');
                temp *= 3;

            } else if (ch == ')'){
                if(deque.isEmpty() || deque.peek() != '('){
                    answer = 0;
                    break;
                }
                if(i > 0 && str.charAt(i - 1) == '('){
                    answer += temp;
                }
                deque.pop();
                temp /= 2;

            } else if (ch == ']'){
                if(deque.isEmpty() || deque.peek() != '['){
                    answer = 0;
                    break;
                }
                if(i > 0 && str.charAt(i - 1) == '['){
                    answer += temp;
                }
                deque.pop();
                temp /= 3;
            }
        }

        if(!deque.isEmpty()){
            answer = 0;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}