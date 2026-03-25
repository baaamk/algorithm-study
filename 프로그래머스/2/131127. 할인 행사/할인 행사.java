import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> target = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            target.put(want[i], number[i]);
        }

        Map<String, Integer> window = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }

        if (check(target, window, want)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            String removeItem = discount[i - 10];
            String addItem = discount[i];

            window.put(removeItem, window.get(removeItem) - 1);
            if (window.get(removeItem) == 0) {
                window.remove(removeItem);
            }

            window.put(addItem, window.getOrDefault(addItem, 0) + 1);

            if (check(target, window, want)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(Map<String, Integer> target, Map<String, Integer> window, String[] want) {
        for (int i = 0; i < want.length; i++) {
            if (window.getOrDefault(want[i], 0) != target.get(want[i])) {
                return false;
            }
        }
        return true;
    }
}