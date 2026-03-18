import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String ans = "";
            String a = br.readLine();
            int j = 0;
            while(j < a.length()){
                if(a.charAt(j) >= '0' && a.charAt(j) <= '9'){
                    ans+= String.valueOf(a.charAt(j));
                } else {
                    if(!ans.equals("")){
                        list.add(removeZero(ans));
                        ans = "";
                    }
                }
                j++;
            }
            if(!ans.equals("")){
                list.add(removeZero(ans));
                ans = "";
            }
            
            
            
            
            
        }
        list.sort((s1, s2) -> {
            if(s1.length() != s2.length()){
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });
        for(String b : list){
            bw.write(b + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    static String removeZero(String s){
        int idx = 0;
        while(idx < s.length() - 1 && s.charAt(idx) == '0'){
            idx++;
        }
        return s.substring(idx);
    }
}