import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder out = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {
                // 태그 시작 전: 단어 먼저 뒤집어 출력
                out.append(word.reverse());
                word.setLength(0);

                inTag = true;
                out.append(ch);
            } else if (ch == '>') {
                inTag = false;
                out.append(ch);
            } else if (inTag) {
                // 태그 안은 그대로
                out.append(ch);
            } else {
                // 태그 밖
                if (ch == ' ') {
                    // 단어 끝
                    out.append(word.reverse());
                    word.setLength(0);
                    out.append(' ');
                } else {
                    // 단어 구성
                    word.append(ch);
                }
            }
        }

        // 마지막 단어 처리
        out.append(word.reverse());

        System.out.print(out.toString());
    }
}