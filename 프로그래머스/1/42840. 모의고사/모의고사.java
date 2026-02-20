import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int [answers.length];  
        int[] b = new int [answers.length];  
        int[] c = new int [answers.length];  
        
        for(int i = 0; i < answers.length; i++){
            a[i] = i % 5 + 1;
            if(i % 2 == 0){
                b[i] = 2;
            } else {
                if(i % 8 == 1){
                    b[i] = 1;
                } else if(i % 8 == 3){
                    b[i] = 3;
                } else if(i % 8 == 5){
                    b[i] = 4;
                } else {
                    b[i] = 5;
                }
            }
            if(i % 10 == 0) {
                c[i] = 3;
            } else if(i % 2 == 1){
                c[i] = c[i - 1];
            } else if(i % 10 == 2){
                c[i] = 1;
            } else if(i % 10 == 4){
                c[i] = 2;
            } else if(i % 10 == 6){
                c[i] = 4;
            } else if(i % 10 == 8){
                c[i] = 5;
            } 
        }
        int a1 = 0;
        int b1 = 0;
        int c1 = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i]){
                a1++;
            }
            if(answers[i] == b[i]){
                b1++;
            }
            if(answers[i] == c[i]){
                c1++;
            }
        }
        
        int max = Math.max(a1, Math.max(b1, c1));
        
        List<Integer> answer2 = new ArrayList<>();
        
        if(a1 == max){
            answer2.add(1);
        }
        if(b1 == max){
            answer2.add(2);
        }
        if(c1 == max){
            answer2.add(3);
        }

        int[] answer = answer2.stream()
	                    .mapToInt(Integer::intValue)
    	                .toArray();
        
        return answer;
    }
}