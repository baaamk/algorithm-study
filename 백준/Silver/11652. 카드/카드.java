import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        long ans = Long.MAX_VALUE;

        for(long key : map.keySet()){
            int cnt = map.get(key);

            if(cnt > max){
                max = cnt;
                ans = key;
            } else if(cnt == max){
                ans = Math.min(ans, key);
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}