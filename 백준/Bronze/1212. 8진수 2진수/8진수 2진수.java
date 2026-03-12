import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.equals("0")) {
            System.out.println("0");
            return;
        }

        String[] map = {"000","001","010","011","100","101","110","111"};
        StringBuilder sb = new StringBuilder();

        // 첫 자리만 따로 처리 (앞 0 제거 효과)
        sb.append(Integer.toBinaryString(s.charAt(0) - '0'));

        // 나머지는 무조건 3비트 유지
        for (int i = 1; i < s.length(); i++) {
            sb.append(map[s.charAt(i) - '0']);
        }

        System.out.println(sb);
    }
}