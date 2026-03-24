import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        
        List<String> list = Arrays.asList(players);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            int spot = map.get(callings[i]);
            String name = players[spot - 1];
            
            players[spot - 1] = callings[i];
            players[spot] = name;
            
            map.put(callings[i], spot -1);
            map.put(name, spot);
        }
        
        
        
        return players;
    }
}