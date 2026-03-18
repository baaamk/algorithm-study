import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        int star = pattern.indexOf('*');
        String before = pattern.substring(0, star);
        String after = pattern.substring(star + 1);

        while (n-- > 0) {
            String str = br.readLine();

            if (str.length() >= before.length() + after.length()
                    && str.startsWith(before)
                    && str.endsWith(after)) {
                bw.write("DA");
            } else {
                bw.write("NE");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}