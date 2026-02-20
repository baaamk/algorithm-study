import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {

        int[] number = Arrays.stream(numbers.split(""))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        boolean[] visited = new boolean[number.length];

        dfs(number, visited, 0);

        int answer = 0;

        for (int x : set) {
            if (isPrime(x)) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[] number, boolean[] visited, int current) {

        if (current != 0) {
            set.add(current);
        }

        for (int i = 0; i < number.length; i++) {
            if (!visited[i]) {

                visited[i] = true;

                dfs(number, visited, current * 10 + number[i]);

                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}