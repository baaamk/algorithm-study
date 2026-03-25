import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a,b) -> {
            String[] pa = split(a);
            String[] pb = split(b);
            
            int headCompare = pa[0].toLowerCase().compareTo(pb[0].toLowerCase());
            if (headCompare != 0) return headCompare;
            
            int numA = Integer.parseInt(pa[1]);
            int numB = Integer.parseInt(pb[1]);
            return numA - numB;
        });
        
        return files;
    }
    
    public static String[] split(String str){
        int idx = 0;
        while(idx < str.length() && !Character.isDigit(str.charAt(idx))){
            idx++;
        }
        
        String head = str.substring(0, idx);
        
        int start = idx;
        
        while(idx < str.length() && Character.isDigit(str.charAt(idx))){
            idx++;
        }
        
        String number = str.substring(start, idx);
        
        return new String[] {head, number};
    }
}