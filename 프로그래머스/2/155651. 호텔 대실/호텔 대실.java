import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] realTime = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            
            int start = toTime(book_time[i][0]);
            int end = toTime(book_time[i][1]) + 10;
            realTime[i][0] = start;
            realTime[i][1] = end;
        }  
        Arrays.sort(realTime, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < realTime.length; i++){
            int start = realTime[i][0];
            int end = realTime[i][1];
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); // 그 방을 뺍니다 (재사용 가능하니까!)
            }
            pq.add(end);
            
        }

        return pq.size();
    }
    
    static int toTime(String time){
        String[] a = time.split(":");
        return Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
    }
}