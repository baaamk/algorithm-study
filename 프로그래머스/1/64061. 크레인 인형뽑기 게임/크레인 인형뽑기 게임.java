import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;
        for(int i = 0; i < moves.length; i++){
            int n = moves[i];
            
            for(int j = 0; j < board.length; j++){
                if(board[j][n - 1] == 0){
                    continue;
                } else {
                    int m = board[j][n - 1];
                    deque.push(m);
                    board[j][n - 1] = 0;
                    break;
                }
            }
            if(!deque.isEmpty()){
                    int temp = deque.pop();
                if(!deque.isEmpty() && temp == deque.peek()){
                    answer += 2;
                    deque.pop();
                } else {
                    deque.push(temp);
                }
            }
            

        }
        
        return answer;
    }
}