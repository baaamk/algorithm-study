import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //다 모았을 때 신고가 k번 이상이면 정지 후 메일 발송
        //누가 누굴 신고했는지 기록해 마지막에 메일 받은 개수 세야함.
        //신고 set으로.
        int[] names = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> rep = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            rep.put(id_list[i], 0);
        }

        for(int i = 0; i < report.length; i++){
            String[] arr = report[i].split(" ");
            if(map.get(arr[0]).add(arr[1])){
                rep.put(arr[1], rep.getOrDefault(arr[1], 0) + 1);
            };
        }
        
        Set<String> banned = new HashSet<>();
        for(int i = 0; i < id_list.length; i++){
            String name = id_list[i];
            if(rep.get(name) >= k){
                banned.add(name);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            int count = 0;
            for(String target : map.get(id_list[i])){
                if(banned.contains(target)){
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}