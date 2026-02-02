import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        Map<String, Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(str.length() >= m){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        
        list.sort((a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            // 1) 빈도 내림차순
            if (freqA != freqB) return freqB - freqA;

            // 2) 길이 내림차순
            if (a.length() != b.length()) return b.length() - a.length();

            // 3) 사전순 오름차순
            return a.compareTo(b);
        });
        
        
        for(String a : list){
            bw.write(a);
            bw.newLine();
        }

        

        bw.flush();
        bw.close();
    }
}