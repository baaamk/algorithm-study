import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            stack.addLast(i);
        }
        while(stack.size() > 1){
            stack.pop();
            int a = stack.pop();
            stack.addLast(a);
        }
        bw.write(stack.pop() + "");
        bw.flush();
        bw.close();
        
    }
}