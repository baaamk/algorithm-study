import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        Map<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.getOrDefault(num, 0) != 0){
                int a = map.get(num) + 1;
                map.put(num, a);
            } else{
                map.put(num, 1);
            }
            
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(num, 0) + " ");
        }
        bw.flush();
        bw.close();
    }
}