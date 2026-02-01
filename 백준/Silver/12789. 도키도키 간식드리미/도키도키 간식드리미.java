import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            stack.addLast(Integer.parseInt(st.nextToken()));
        }
        Deque<Integer> stack2 = new ArrayDeque<>();
        int num = 1;
        while(!stack.isEmpty()){
            if(stack.peekFirst() == num){
                stack.pollFirst();
                num++;
            } else{
                stack2.push(stack.pollFirst());
            }
            while(!stack2.isEmpty() && stack2.peek() == num){
            stack2.pop();
            num++;
        }
        }
        

        
        if(stack2.isEmpty()){
            bw.write("Nice");
            
        }else{
            bw.write("Sad");
        }

        bw.flush();
        bw.close();
        
    }
}