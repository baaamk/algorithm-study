import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N==number){
            return 1;
        }
        
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        for(int i = 1; i <= 9; i++){
            Set<Integer> current = new HashSet<>();
            int repeated = 0;
            for(int j = 0; j < i; j++){
                repeated = repeated * 10 + N;
            }
            current.add(repeated);
            for(int j = 1; j <i; j++){
                Set<Integer> left = dp.get(j);
                Set<Integer> right = dp.get(i - j);

                for(int a : left){
                    for(int b : right){
                        current.add(a+b);
                        current.add(a-b);
                        current.add(a*b);
                        if(b != 0){
                            current.add(a/b);
                        }
                    }
                }
               
            }
            
            if(current.contains(number)){
                return i;
            }
            dp.add(current);
            
        }
        return -1;
    }
}