import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = br.readLine();
            list.add(name);
            map.put(name, i + 1);
        }
        
        for(int i = 0; i < m; i++){
            String a = br.readLine();
            char c = a.charAt(0);
            if(c >= '0' && c <= '9'){
                int b = Integer.parseInt(a);
                bw.write(list.get(b - 1) + "");
                bw.newLine();
            } else {
                bw.write(String.valueOf(map.get(a)));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        
        
    }
}