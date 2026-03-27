import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        // 회전 시작점 i
        for(int i = 0; i < n; i++){
            // 스택은 무조건 1개만 씁니다!
            Deque<Character> stack = new ArrayDeque<>();
            boolean ok = true;
            
            for(int j = 0; j < n; j++){
                char c = s.charAt((j + i) % n); // 회전 로직 완벽!
                
                // 1. 여는 괄호는 무조건 스택에 넣는다
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } 
                // 2. 닫는 괄호일 때
                else {
                    // 스택이 비어있는데 닫는 괄호가 오면 아웃
                    if(stack.isEmpty()) {
                        ok = false;
                        break;
                    }
                    
                    // 스택 맨 위의 '여는 괄호'와 현재 '닫는 괄호'의 짝이 맞는지 확인
                    char top = stack.peek();
                    if(c == ')' && top == '(') stack.pop();
                    else if(c == '}' && top == '{') stack.pop();
                    else if(c == ']' && top == '[') stack.pop();
                    else {
                        // 짝이 안 맞으면 (예: 맨 위는 '[' 인데 ')' 가 들어오면) 바로 아웃
                        ok = false;
                        break;
                    }
                }
            }
            
            // 끝까지 돌았는데 무사히 통과했고, 스택도 깔끔하게 비어있다면 성공!
            if(ok && stack.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}