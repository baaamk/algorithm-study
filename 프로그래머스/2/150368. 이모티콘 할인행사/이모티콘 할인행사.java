class Solution {
    static int bestSubscriber;
    static int bestSales;
    static int[] discountRate = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        //사용자는 일정 할인율 이상 할인하는 이모티콘 모두 구매. if 구매비용이 k원 이상일 경우 취소하고 이모티콘 플러스로 도망
        //이때 이모티콘마다의 할인율을 우리가 조정해야함. 10, 20, 30, 40
        //이모티콘 플러스 서비스 가입자 최대일 때 이모티콘 판매액 둘 다 출력.
        
        int m = emoticons.length;
        int totalCase = 1;
        
        for(int i = 0; i < m; i++){
            totalCase *= 4;
        }
        
        bestSubscriber = 0;
        bestSales = 0;
        
        for(int mask = 0; mask < totalCase; mask++){
            int[] selected = new int[m];
            int temp = mask;
            
            for(int i = 0; i < m; i++){
                selected[i] = discountRate[temp % 4];
                temp /= 4;
            }
            
            calculate(users, emoticons, selected);
        }
        
        
        int[] answer = {bestSubscriber, bestSales};
        return answer;
    }
    
    public static void calculate(int[][] users, int[] emoticons, int[] selected){
        int subscriber = 0;
        int sales = 0;
        
        for(int i = 0; i < users.length; i++){
            int needDiscount = users[i][0];
            int limitPrice = users[i][1];
            int sum = 0;
            
            for(int j = 0; j < emoticons.length; j++){
                if(selected[j] >= needDiscount){
                    sum += emoticons[j] * (100-selected[j]) / 100;
                }
            }
            
            if(sum >= limitPrice){
                subscriber++;
            } else {
                sales += sum;
            }
        }
        
        if(subscriber > bestSubscriber){
            bestSubscriber = subscriber;
            bestSales = sales;
        } else if (subscriber == bestSubscriber && sales > bestSales) {
            bestSales = sales;
        }
    }
}