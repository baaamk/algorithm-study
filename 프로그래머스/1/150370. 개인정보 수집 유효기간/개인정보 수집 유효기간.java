import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        //투데이는 오늘 날짜.
        //terms는 약관과 개월
        //privacies는 수집 일자와 약관. 수집일자 + 약관개월 이 오늘보다 이전이면 소각, 오늘포함 이후면 킵.
        //day는 28일까지.
        
        int cur = toInt(today);
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < terms.length; i++){
            String[] strs = terms[i].split(" ");
            map.put(strs[0], Integer.parseInt(strs[1]));
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            String type = temp[1];
            int toDate = toInt(temp[0]);
            if(toDate + map.get(type) * 28 <= cur){
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static int toInt(String date){
        String[] arr = date.split("\\.");
        int year = Integer.parseInt(arr[0]) * 28 * 12;
        int month = Integer.parseInt(arr[1]) * 28;
        int day = Integer.parseInt(arr[2]);
        return year + month + day;
    }
}