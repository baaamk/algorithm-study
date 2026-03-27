class Solution {
    public int solution(String s) {
        int min = s.length();

        for (int step = 1; step <= s.length(); step++) {
            StringBuilder sb = new StringBuilder();
            String prev = "";
            int count = 1;

            for (int i = 0; i < s.length(); i += step) {
                int end = Math.min(i + step, s.length());
                String cur = s.substring(i, end);

                if (cur.equals(prev)) {
                    count++;
                } else {
                    if (!prev.equals("")) {
                        if (count > 1) {
                            sb.append(count);
                        }
                        sb.append(prev);
                    }
                    prev = cur;
                    count = 1;
                }
            }

            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);

            min = Math.min(min, sb.length());
        }

        return min;
    }
}