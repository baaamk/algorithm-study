import java.io.*;
import java.util.*;

class Main {

    static void cantor(char[] arr, int start, int len) {
        if (len == 1) {
            return;
        }

        int third = len / 3;

        // 가운데 1/3을 공백으로
        for (int i = start + third; i < start + 2 * third; i++) {
            arr[i] = ' ';
        }

        // 왼쪽, 오른쪽 재귀
        cantor(arr, start, third);
        cantor(arr, start + 2 * third, third);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            int n = Integer.parseInt(line);

            int len = 1;
            for (int i = 0; i < n; i++) {
                len *= 3;
            }

            char[] arr = new char[len];
            for (int i = 0; i < len; i++) {
                arr[i] = '-';
            }

            cantor(arr, 0, len);

            bw.write(arr);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}