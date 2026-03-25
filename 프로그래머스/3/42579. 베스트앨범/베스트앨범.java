import java.util.*;

class Solution {
    //장르 먼저
    //장르 내에서 재생수대로
    //장르내에서 재생횟수같다면 고유번호 낮은 노래 먼저 수록.
    public int[] solution(String[] genres, int[] plays) {
        //맵으로 <장르, 고유번호 리스트<재생횟수>> 하고 상위 2개.랑 고유번호 낮은 노래
        Map<String, Integer> total = new HashMap<>();
        
        Map<String, List<int[]>> map = new HashMap<>();
        
        for(int i = 0; i <genres.length; i++){
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[]{i, plays[i]});
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> list = new ArrayList<>(total.keySet());

        list.sort((a,b) -> 
           total.get(b) - total.get(a)
        );

        List<Integer> result = new ArrayList<>();

        
        for(String genre : list){
            List<int[]> songs = map.get(genre);
            
            songs.sort((a,b) -> {
                if(b[1] != a[1]){
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });
            
            result.add(songs.get(0)[0]);
            if(songs.size() > 1){
                result.add(songs.get(1)[0]);
            }
        }
        int[] answer = new int[result.size()];
        
        
        
        for(int i =0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}