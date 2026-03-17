import java.io.*;
import java.util.*;

class Main {

    static long ans = 0;

    static void seqSum(List<Integer> v) {
        while (v.size() > 1) {
            int n = v.size();
            ans += (long)v.get(n - 1) * v.get(n - 2);
            v.remove(n - 1);
            v.remove(n - 2);
        }
        if (v.size() == 1) {
            ans += v.get(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> seqP = new ArrayList<>();
        List<Integer> seqN = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());

            if (t == 1) ans++;
            else if (t > 0) seqP.add(t);
            else seqN.add(t);
        }

        Collections.sort(seqP); // 오름차순
        Collections.sort(seqN, Collections.reverseOrder()); // 내림차순

        seqSum(seqP);
        seqSum(seqN);

        System.out.println(ans);
    }
}