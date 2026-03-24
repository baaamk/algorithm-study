class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = toSeconds(h1, m1, s1);
        int end = toSeconds(h2, m2, s2);

        int answer = count(end) - count(start);

        if (isAlarmTime(start)) {
            answer++;
        }

        return answer;
    }

    private int toSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    // (0초, t초] 구간의 누적 알람 수
    private int count(int t) {
        int secondMinute = (int) (t * 59L / 3600);
        int secondHour = (int) (t * 719L / 43200);

        int result = secondMinute + secondHour;

        if (t >= 43200) {
            result--;
        }

        return result;
    }

    private boolean isAlarmTime(int t) {
        if (t == 0 || t == 43200) {
            return true;
        }

        return (t * 59L) % 3600 == 0 || (t * 719L) % 43200 == 0;
    }
}