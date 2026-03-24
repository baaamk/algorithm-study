class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        //현재위치가 오프닝 사이인지 먼저 판단 -> 맞다면 오프닝 끝 시간으로 이동.
        //앞 10초 뒤 10초 맨 끝일 경우 그 끝에 머무름
        
        int videoLen = toSec(video_len);
        int cur = toSec(pos);
        int ops = toSec(op_start);
        int ope = toSec(op_end);
        
        if(cur >= ops && cur < ope){
            cur = ope;
        }
        for(int i = 0; i < commands.length; i++){
            String command = commands[i];
            if(command.equals("next")){
                cur += 10;
                if(cur > videoLen){
                cur = videoLen;
                }
            }
            if(command.equals("prev")){
                cur -= 10;
                if (cur < 0){
                cur = 0;
                }
            }
            
            if (cur >= ops && cur < ope){
                cur = ope;
            }
        }
        
        int min = cur / 60;
        int sec = cur % 60;
        
        
        String answer = String.format("%02d:%02d", min, sec);
        return answer;
    }
    
    public static int toSec(String time){
        String[] len = time.split(":");
        int min = Integer.parseInt(len[0]);
        int sec = Integer.parseInt(len[1]);
        
        return min * 60 + sec;
    }
}