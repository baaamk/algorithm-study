import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            // 1순위: 소요 시간 (짧은 순)
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            // 2순위: 요청 시점 (빠른 순)
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            // 3순위: 작업 번호 (작은 순)
            return o1[2] - o2[2]; 
        });
        
        int totalTime = 0;
        int idx = 0;
        int times = 0;
        int completedCount = 0;
        int currentTime = 0;
        
        while(completedCount < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= currentTime){
                pq.add(new int[] {jobs[idx][0], jobs[idx][1], idx});
                idx++;
            }
            
            if(pq.isEmpty()){
                currentTime = jobs[idx][0];
            } else {
                int[] cur = pq.poll();
                int start = cur[0];
                int duration = cur[1];
                totalTime += currentTime + duration - start;
                
                currentTime += duration;
                completedCount++;
            }
        }

        
        answer = totalTime/jobs.length;
        
        
        return answer;
    }
}