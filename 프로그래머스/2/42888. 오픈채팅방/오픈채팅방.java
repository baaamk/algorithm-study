import java.util.*;

class Solution {
    //나간 후 닉네임 변경, 나가지 않고 닉네임 변경 => 채팅방에 있는 모든 닉네임 변경.
    // enter -> id잘 볼것.
    public String[] solution(String[] record) {
        

        List<String[]> stamp = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            String type = arr[0];
            String uid = arr[1];
            String nickName = "";
            if(!type.equals("Leave")){
                nickName = arr[2];
            }
            
            
            if(type.equals("Enter")){
                map.put(uid, nickName);
                stamp.add(new String[] {uid, type});
            } else if(type.equals("Change")){
                map.put(uid, nickName);
            } else {
                stamp.add(new String[] {uid, type});
            }
        }
        String[] answer = new String[stamp.size()];
        for(int i = 0; i < stamp.size(); i++){
            String[] point = stamp.get(i);
            String uid = point[0];
            String type = point[1];
            if(type.equals("Enter")){
                answer[i] = map.get(uid) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(uid) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }

}