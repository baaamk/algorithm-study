class Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        int[] answer = {};
        for (int h = 1; h * h <= total; h++){
            if(total % h != 0){
                continue;
            }
            
            int w = total / h;
            
            if(w < h){
                continue;
            }
            
            if((w - 2) * (h - 2) == yellow){
                answer = new int[] {w, h};
            }
        }
        return answer;
    }
}