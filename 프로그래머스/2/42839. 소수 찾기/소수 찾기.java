import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        int n = numbers.length();
        visited = new boolean[n];
        
        dfs(numbers,"");
        
        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }
        //만들 수 있는 모든 숫자 확인.
        return answer;
    }
    
    
    public static boolean isPrime(int number){
        if(number < 2){
            return false;
        }
        for(int i = 2; i * i <= number; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static void dfs(String numbers, String result){
        if(!result.equals("")){
            set.add(Integer.parseInt(result));
        }
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, result + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
}