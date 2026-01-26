import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
           set.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>(set);
        
        Collections.sort(list, (s1, s2) -> {
            // 1. 길이 비교
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            // 2. 길이가 같으면 사전순
            return s1.compareTo(s2);
        });
        
        for(String s : list){
            bw.write(s);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}