class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // d: 현재 트럭의 배달 가능 잔액 (음수면 더 배달해야 함)
        // p: 현재 트럭의 수거 가능 잔액 (음수면 더 수거해야 함)
        int d = 0;
        int p = 0;

        // 가장 먼 집(n-1)부터 거꾸로 스캔
        for (int i = n - 1; i >= 0; i--) {
            int count = 0; // 이 집 때문에 창고를 몇 번 다녀와야 하는가?

            // 이 집에 배달할 게 남았거나 수거할 게 남았는데, 
            // 현재 장부상(d, p) 여유가 없다면 창고에 다녀와야 함
            while (deliveries[i] > d || pickups[i] > p) {
                count++;
                d += cap; // 창고 갔다오면 cap만큼 배달/수거 능력이 생김
                p += cap;
            }

            // 이번 방문으로 이 집의 용량을 털어내고 남은 능력을 장부에 기록
            d -= deliveries[i];
            p -= pickups[i];

            // 창고를 다녀왔다면 (count > 0), 가장 먼 거리인 (i+1)을 왕복(*2)함
            if (count > 0) {
                answer += (long) (i + 1) * count * 2;
            }
        }
        
        return answer;
    }
}