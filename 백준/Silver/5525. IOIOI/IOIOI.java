import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); // 사실상 길이지만, 안 써도 됨
        String S = br.readLine();

        int ans = 0;
        int k = 0; // 연속된 "IOI" 개수

        // i는 가운데 'O' 위치를 기준으로 봄: S[i-1]S[i]S[i+1] 가 "IOI"인지 체크
        for (int i = 1; i < S.length() - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                k++; // "IOI" 하나 더 이어짐
                if (k >= N) ans++; // k가 N 이상이면 PN 하나 성립 (겹침 허용)
                i++; // 다음 검사로 넘어갈 때 i+1의 'I'는 이미 썼으니 i를 한 칸 더 점프
            } else {
                k = 0; // 끊기면 초기화
            }
        }

        System.out.println(ans);
    }
}