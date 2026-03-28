class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        //마법의 돌 최소값 찾기
        //현재층에서 더한게 0보다 작다면 이동 x
        while(storey>0){
            int point = storey % 10;
            if(point < 5){
                answer += point;
            } else if(point > 5){
                answer += 10 - point;
                storey += 10;
            } else {
                int next = (storey / 10) % 10;
                if(next >= 5){ 
                    // 앞자리가 5 이상이면 (예: 75 -> 80으로 만드는 게 이득)
                    answer += 5;
                    storey += 10; // 위로 올렸으니 앞자리에 1 더해주기
                } else {
                    // 앞자리가 4 이하면 (예: 45 -> 40으로 만드는 게 이득)
                    answer += 5;
                    // 버렸으니 앞자리는 그대로 둠!
                }
                
            }
            storey /= 10;
        }
        return answer;
    }
}