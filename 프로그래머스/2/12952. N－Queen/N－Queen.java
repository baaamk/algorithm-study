import java.util.*;

class Solution {
    int[] board;
    int count;
    public int solution(int n) {
        board = new int[n];
        dfs(0,n);

        return count;
    }
    
    void dfs(int row, int n){
        if(row == n){
            count++;
            return;
        }
        
        for(int col = 0; col < n; col++){
            if(isSafe(row, col)){
                board[row] = col;
                dfs(row + 1, n);
            }
        }
    }
    
    boolean isSafe(int row, int col){
        for(int i = 0; i < row; i++){
            if(board[i] == col){
                return false;
            }
            if(Math.abs(row - i) == Math.abs(board[i] - col)){
                return false;
            }
        }
        return true;
    }
}