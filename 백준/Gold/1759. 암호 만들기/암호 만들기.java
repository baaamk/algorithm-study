import java.util.*;
import java.io.*;

class Main {
    static int l, c;
    static char[] arr;
    static char[] select;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        select = new char[l];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        make(0, 0, 0, 0);

        bw.flush();
        bw.close();
    }

    static void make(int depth, int start, int vowel, int consonant) throws IOException {
        if (depth == l) {
            if (vowel >= 1 && consonant >= 2) {
                bw.write(select);
                bw.newLine();
            }
            return;
        }

        for (int i = start; i < c; i++) {
            select[depth] = arr[i];

            if (isVowel(arr[i])) {
                make(depth + 1, i + 1, vowel + 1, consonant);
            } else {
                make(depth + 1, i + 1, vowel, consonant + 1);
            }
        }
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}