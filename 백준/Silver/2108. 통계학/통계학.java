import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(arr);

        // 1. 평균
        bw.write(Math.round((double)sum / n) + "\n");

        // 2. 중앙값
        bw.write(arr[n/2] + "\n");

        // 3. 최빈값
        int maxFreq = 0;
        for(int freq : map.values()){
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer> modes = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq){
                modes.add(key);
            }
        }

        Collections.sort(modes);

        if(modes.size() == 1) {
            bw.write(modes.get(0) + "\n");
        } else {
            bw.write(modes.get(1) + "\n"); // 두 번째로 작은 값
        }

        // 4. 범위
        bw.write((arr[n-1] - arr[0]) + "\n");

        bw.flush();
        bw.close();
    }
}