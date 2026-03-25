import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            String[] arr = records[i].split(" ");
            int time = toTime(arr[0]);
            String car = arr[1];
            String type = arr[2];
            
            if(type.equals("IN")){
                inMap.put(car, time);
            } else {
                int take = time - inMap.get(car);
                sumMap.put(car, sumMap.getOrDefault(car, 0) + take);
                inMap.remove(car);
            }
        }
        
        for(String car : inMap.keySet()){
            int take = toTime("23:59") - inMap.get(car);
            sumMap.put(car, sumMap.getOrDefault(car, 0) + take);
        }
        List<String> carList = new ArrayList<>(sumMap.keySet());
        Collections.sort(carList);
        
        int[] answer = new int[carList.size()];
        
        for(int i = 0; i < carList.size(); i++){
            int time = sumMap.get(carList.get(i));
            answer[i] = calc(time, fees);
        }
        
        return answer;
    }
    
    static int calc(int time, int[] fees){
        if(time <= fees[0]){
            return fees[1];
        } else {
            time = time - fees[0];
            int result = (int) Math.ceil((double)time/fees[2]) * fees[3];
            return fees[1] + result;
        }
    }
    
    static int toTime(String time){
        String[] rTime = time.split(":");
        return Integer.parseInt(rTime[0]) * 60 + Integer.parseInt(rTime[1]);
    }
}