import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = new int[answers.length];
        int[] b = new int[answers.length];
        int[] c = new int[answers.length];
        
        for(int i = 0; i < answers.length; i++){
            a[i] = i % 5 + 1;
            if(i % 2 == 0) {
                b[i] = 2;
            } else if(i % 8 == 1){
                b[i] = 1;
            } else if(i % 8 == 3){
                b[i] = 3;
            } else if(i % 8 == 5){
                b[i] = 4;
            } else if(i % 8 == 7){
                b[i] = 5;
            }
            if(i % 10 == 0 || i % 10 == 1){
                c[i] = 3;
            } else if(i % 10 == 2 || i % 10 == 3){
                c[i] = 1;
            } else if(i % 10 == 4 || i % 10 == 5){
                c[i] = 2;
            } else if(i % 10 == 6 || i % 10 == 7){
                c[i] = 4;
            } else if(i % 10 == 8 || i % 10 == 9){
                c[i] = 5;
            }
            
        }
        int ay = 0;
        int by = 0;
        int cy = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i]){
                ay++;
            }
            if(answers[i] == b[i]){
                by++;
            }
            if(answers[i] == c[i]){
                cy++;
            }
        }
        
        
        
        int max = Math.max(ay, Math.max(by, cy));
        List<Integer> list = new ArrayList<>();
        
        
        if(max == ay){
            list.add(1);
        }
        if(max == by){
            list.add(2);
        }
        if(max == cy){
            list.add(3);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}