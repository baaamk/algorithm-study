class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(canCross(stones,mid, k)){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        
        return answer;
    }
    
    boolean canCross(int[] stones, int mid, int k){
        int count = 0;
        for (int stone : stones) {
            if (stone < mid) {
                // 돌의 숫자가 mid보다 작으면 mid번째 사람은 이 돌을 못 밟음
                count++;
            } else {
                // 밟을 수 있는 돌을 만나면 연속 카운트 초기화
                count = 0;
            }

            // 못 밟는 돌이 연속으로 k개가 되면 못 건넘
            if (count >= k) return false;
        }
        return true;
    }
}