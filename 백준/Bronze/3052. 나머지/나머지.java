import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //42로 나눈 서로 다른 나머지 개수.
        //1이 기존에 존재한다. 그럼 세지 않음. 
        Set<Integer> a = new HashSet<>();
        
        for(int i = 0; i < 10; i++){
            int n = Integer.parseInt(br.readLine());
            a.add(n%42);
        }
        bw.write(String.valueOf(a.size()));
        bw.flush();
        bw.close();
    }
}