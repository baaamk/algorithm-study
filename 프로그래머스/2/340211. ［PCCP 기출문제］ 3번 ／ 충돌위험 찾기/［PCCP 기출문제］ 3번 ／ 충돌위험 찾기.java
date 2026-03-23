import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>> allPath = new ArrayList<>();
        int maxTime = 0;
        
        for(int i = 0; i < routes.length; i++){
            List<int[]> path = new ArrayList<>();
            
            int startPoint = routes[i][0] - 1;
            int r = points[startPoint][0];
            int c = points[startPoint][1];
            
            path.add(new int[] {r,c});
            
            for(int j = 0; j < routes[i].length; j++){
                int nextPoint = routes[i][j] - 1;
                int targetR = points[nextPoint][0];
                int targetC = points[nextPoint][1];
                
                while(r != targetR){
                    if(r < targetR){
                        r++;
                    } else {
                        r--;
                    }
                    path.add(new int[] {r, c});
                }
                while(c != targetC){
                    if(c < targetC){
                        c++;
                    } else {
                        c--;
                    }
                    path.add(new int[] {r, c});
                }
            }
            allPath.add(path);
            maxTime = Math.max(maxTime, path.size());
        }
        int answer = 0;
        for(int t = 0; t < maxTime; t++){
            Map<String, Integer> countMap = new HashMap<>();
            
            for(List<int[]> path : allPath){
                if(t>=path.size()){
                    continue;
                }
                int[] pos = path.get(t);
                String key = pos[0] +", " +pos[1];
                countMap.put(key, countMap.getOrDefault(key, 0)+1);
            }
            for(int count : countMap.values()){
                if(count >= 2){
                    answer++;
                }
            }
            
        }
        return answer;
    }
}