import java.io.*;
import java.util.*;

public class Main {
    static List<String> ans = new ArrayList<>();
    static String s;

    static void eraseChars(BufferedReader br) throws IOException {
        s = br.readLine();
        int pos = 0;
        int nxtPos = 0;

        while (true) {
            while (nxtPos < s.length() && s.charAt(nxtPos) >= 'a' && s.charAt(nxtPos) <= 'z') {
                nxtPos++;
            }

            pos = nxtPos;
            if (pos >= s.length()) break;

            while (nxtPos < s.length() && s.charAt(nxtPos) >= '0' && s.charAt(nxtPos) <= '9') {
                nxtPos++;
            }

            ans.add(s.substring(pos, nxtPos));
            pos = nxtPos;
        }
    }

    static void eraseZeros() {
        for (int i = 0; i < ans.size(); i++) {
            String str = ans.get(i);
            int pos = 0;

            while (pos < str.length() && str.charAt(pos) == '0') {
                pos++;
            }

            String ss = str.substring(pos);
            if (ss.equals("")) ss = "0";

            ans.set(i, ss);
        }
    }

    static int cmp(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b);
        }
        return a.length() - b.length();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            eraseChars(br);
        }

        eraseZeros();

        ans.sort((a, b) -> cmp(a, b));

        for (String str : ans) {
            bw.write(str);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}