class Solution {
    public int solution(int n, int k) {
        
        
        String converted = Integer.toString(n, k);
        String[] arr = converted.split("0");
        
        
        int answer = 0;
        
        for(String s : arr){
            if(s.equals("")){
                continue;
            }
            long num = Long.parseLong(s);
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean isPrime(long num){
        if(num < 2){
            return false;
        }
        
        for(long i = 2; i * i <= num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}