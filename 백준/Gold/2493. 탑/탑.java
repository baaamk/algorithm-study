import java.util.*;
import java.io.*;

class Main{
    static class Tower{
        int idx;
        int h;
        
        Tower (int idx, int h){
            this.idx = idx;
            this.h = h;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Tower> stack = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++){
            int h = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().h < h){
                stack.pop();
            }
            if(stack.isEmpty()){
                bw.write("0 ");
            } else {
                bw.write(stack.peek().idx + " ");
            }
            
            stack.push(new Tower(i, h));
        }
        bw.flush();
        bw.close();
    }
}