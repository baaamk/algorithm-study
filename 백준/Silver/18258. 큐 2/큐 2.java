import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(str.equals("pop")){
                if(stack.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(stack.pop() + "");
                    bw.newLine();
                }
            } else if(str.equals("size")){
                bw.write(stack.size() + "");
                bw.newLine();
            } else if(str.equals("empty")){
                if(stack.isEmpty()){
                    bw.write("1");
                    bw.newLine();
                } else {
                    bw.write("0");
                    bw.newLine();
                }
            } else if(str.equals("front")){
                if(stack.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(stack.peek() + "");
                    bw.newLine();
                }
            } else if(str.equals("back")){
                if(stack.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(stack.peekLast() + "");
                    bw.newLine();
                }
            } else {
                st = new StringTokenizer(str);
                st.nextToken();
                int m = Integer.parseInt(st.nextToken());
                stack.addLast(m);
            }
        }
        bw.flush();
        bw.close();
        
    }
}