import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> con = new ArrayDeque<>(); //1번부터 상자 내릴 수 있음.
        Deque<Integer> temp = new ArrayDeque<>(); //임시로 넣는다. 스택으로.
        
        for(int i = 1; i <= order.length; i++){
            con.add(i);
        }
        
        for(int i = 0; i < order.length; i++){
            int target = order[i];
            while(!con.isEmpty() && con.peek() < target){
                temp.push(con.pop());
            }
            if(!con.isEmpty() && con.peek() == target){
                con.pop();
                answer++;
            } else if(!temp.isEmpty() && temp.peek() == target){
                temp.pop();
                answer++;
            } else {
                break;
            }
            
        }
        return answer;
    }
}