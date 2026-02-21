import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int h = n - i;              // 남은 논문 수 = h 후보
            int cited = citations[i];   // 이 논문의 인용수(오름차순이니까 i가 커질수록 큼)

            if (cited >= h) {
                answer = h;
                break; // 가장 큰 h부터 내려오므로 첫 만족이 정답
            }
        }

        
        return answer;
    }
}