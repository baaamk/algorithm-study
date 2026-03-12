import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                stack.pop();
            } else{
                stack.push(a);
            }
        }
        int sum = 0;
        for(Integer b : stack){
            sum += b;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}