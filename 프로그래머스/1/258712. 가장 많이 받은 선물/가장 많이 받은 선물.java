import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 이름 -> 인덱스
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(friends[i], i);
        }

        int[][] giftCount = new int[n][n]; // i가 j에게 준 선물 수
        int[] giftScore = new int[n];      // 선물지수
        int[] nextMonth = new int[n];      // 다음 달 받을 선물 수

        // 기록
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            int from = indexMap.get(temp[0]);
            int to = indexMap.get(temp[1]);

            giftCount[from][to]++;
            giftScore[from]++;
            giftScore[to]--;
        }

        // 다음 달 받을 선물 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftCount[i][j] > giftCount[j][i]) {
                    nextMonth[i]++;
                } else if (giftCount[i][j] < giftCount[j][i]) {
                    nextMonth[j]++;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonth[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonth[j]++;
                    }
                }
            }
        }

        int answer = 0;
        for (int count : nextMonth) {
            answer = Math.max(answer, count);
        }

        return answer;
    }
}