import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
        m = convert(m);
        for(int i = 0; i < musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            int start = toTime(info[0]);
            int end = toTime(info[1]);
            int totalTime = end - start;
            String origin = convert(info[3]);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < totalTime; j++) {
                sb.append(origin.charAt(j % origin.length()));
            }
            String mel = sb.toString();
            
            if(mel.contains(m)){
                if(totalTime > maxTime){
                    maxTime = totalTime;
                    answer = info[2];
                }
            }
        }
        
    
        return answer;
    }
    
    public int toTime(String time){
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public String convert(String s){
    return s.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a")
            .replace("B#", "b")
            .replace("E#", "e");
    }
}