import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String key = br.readLine().trim();
        String cipher = br.readLine().trim();

        int N = key.length();           // 열 개수
        int L = cipher.length();
        int R = L / N;                  // 행 개수

        char[][] table = new char[R][N];

        Character[] sortedKey = new Character[N];
        for (int i = 0; i < N; i++) {
            sortedKey[i] = key.charAt(i);
        }


        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> {
            if (key.charAt(a) != key.charAt(b))
                return key.charAt(a) - key.charAt(b);
            return a - b;   // 같은 문자면 왼쪽 먼저
        });


        int pos = 0;
        for (int i = 0; i < N; i++) {
            int col = order[i];   // 이 정렬열이 원래 어디 열이었는지
            for (int r = 0; r < R; r++) {
                table[r][col] = cipher.charAt(pos++);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(table[r][c]);
            }
        }

        System.out.print(sb.toString());
    }
}