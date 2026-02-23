import java.io.*;
import java.util.*;

public class Main {

    // ====== 전역 변수들 ======

    static int N;                 // 교실 한 변의 길이 (N x N)
    static int[][] seat;          // seat[r][c] = (r,c) 자리에 앉아있는 학생 번호 (0이면 빈 자리)
    static int[][] like;          // like[학생번호][0..3] = 해당 학생이 좋아하는 학생 4명의 번호
    static int[] score = {0, 1, 10, 100, 1000};  // 인접 좋아하는 학생 수(0~4)에 따른 만족도 점수

    // 상/하/좌/우 탐색을 위한 방향 배열
    // direction = 0 => 위, 1 => 아래, 2 => 왼쪽, 3 => 오른쪽
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 입력: N 읽기
        N = Integer.parseInt(br.readLine());
        int total = N * N; // 총 학생 수

        // 2) 교실 좌석 배열, 좋아하는 학생 배열 초기화
        seat = new int[N][N];
        like = new int[total + 1][4]; // 학생 번호가 1..N^2 이므로 0번 인덱스는 안씀

        // 3) 학생 정보를 '입력 순서대로' 읽고, 읽는 즉시 자리 배치
        //    (문제에서 "선생님이 정한 순서대로" 배치하라고 했고, 그 순서가 입력으로 주어짐)
        for (int i = 0; i < total; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken()); // 현재 배치할 학생 번호

            // 현재 학생이 좋아하는 학생 4명 저장
            for (int j = 0; j < 4; j++) {
                like[student][j] = Integer.parseInt(st.nextToken());
            }

            // 규칙(1~3)대로 student를 교실에 앉힘
            place(student);
        }

        // 4) 모든 학생 배치가 끝났으므로 만족도 합 계산 후 출력
        System.out.println(calc());
    }

    // ====== 자리 배치 함수 ======
    // 규칙:
    // 1) 좋아하는 학생이 인접한 칸(상하좌우)이 가장 많은 칸
    // 2) (1)에서 여러 개면 인접한 빈 칸이 가장 많은 칸
    // 3) (2)에서도 여러 개면 행 번호가 가장 작은 칸, 그 다음 열 번호가 가장 작은 칸
    static void place(int student) {

        // bestR, bestC: 현재까지 발견한 "최적 자리"의 좌표
        // bestLike: 그 자리에서 인접 좋아하는 학생 수(최대값을 유지)
        // bestEmpty: 그 자리에서 인접 빈 칸 수(최대값을 유지)
        //
        // -1로 시작하는 이유:
        // 좋아하는 학생 수, 빈 칸 수는 최소 0이므로 -1로 시작하면
        // 첫 번째 빈 칸이 무조건 갱신되어 초기 최적값을 잡을 수 있음.
        int bestR = -1;
        int bestC = -1;
        int bestLike = -1;
        int bestEmpty = -1;

        // 교실의 모든 칸을 보면서 "student가 앉을 수 있는 후보 자리"를 평가한다.
        for (int r = 0; r < N; r++) {

            for (int c = 0; c < N; c++) {

                // 이미 누가 앉아있는 자리는 후보가 될 수 없음
                if (seat[r][c] != 0) {
                    continue;
                }

                // 후보 자리 (r,c)에 대해 아래 2가지를 계산해야 함:
                // likeCnt  = 인접(상하좌우) 4칸 중에서 "student가 좋아하는 학생"이 앉아있는 칸 수
                // emptyCnt = 인접 4칸 중에서 "빈 칸"의 개수
                int likeCnt = 0;
                int emptyCnt = 0;

                // 상/하/좌/우 4방향 확인
                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d]; // 인접한 행
                    int nc = c + dc[d]; // 인접한 열

                    // 교실 범위를 벗어나면 무시
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    // 인접 칸이 비어있으면 emptyCnt 증가
                    if (seat[nr][nc] == 0) {
                        emptyCnt++;
                    } else {
                        // 인접 칸에 학생이 앉아있다면 그 학생이 student가 좋아하는 학생인지 확인
                        if (isLiked(student, seat[nr][nc])) {
                            likeCnt++;
                        }
                    }
                }

                // 이제 (r,c)가 "현재 최적 자리(bestR,bestC)"보다 좋은지 비교한다.
                // 비교 우선순위:
                // 1) likeCnt가 큰 자리
                // 2) 같다면 emptyCnt가 큰 자리
                // 3) 같다면 r이 작은 자리
                // 4) 같다면 c가 작은 자리
                //
                // 아래 조건은 위 우선순위를 그대로 코드로 옮긴 것.
                if (likeCnt > bestLike ||
                    (likeCnt == bestLike && emptyCnt > bestEmpty) ||
                    (likeCnt == bestLike && emptyCnt == bestEmpty && (bestR == -1 || r < bestR)) ||
                    (likeCnt == bestLike && emptyCnt == bestEmpty && r == bestR && c < bestC)) {

                    // (r,c)가 더 좋은 자리이므로 최적 자리 정보를 갱신한다.
                    bestLike = likeCnt;
                    bestEmpty = emptyCnt;
                    bestR = r;
                    bestC = c;
                }
            }
        }

        // 최종적으로 선택된 최적 자리에 student를 앉힌다.
        seat[bestR][bestC] = student;
    }

    // ====== 좋아하는 학생인지 확인하는 함수 ======
    // student가 other를 좋아하면 true, 아니면 false
    static boolean isLiked(int student, int other) {

        // 학생은 항상 좋아하는 학생이 4명으로 고정이므로 4번만 확인하면 됨
        for (int i = 0; i < 4; i++) {
            if (like[student][i] == other) {
                return true;
            }
        }
        return false;
    }

    // ====== 만족도 계산 함수 ======
    // 모든 학생 배치가 끝난 후:
    // 각 자리의 학생에 대해 인접(상하좌우) 칸에 앉은 좋아하는 학생 수를 세고,
    // 그 개수에 해당하는 점수(score[개수])를 합산한다.
    static int calc() {

        int sum = 0;

        // 모든 좌석을 돌면서 학생별 만족도 계산
        for (int r = 0; r < N; r++) {

            for (int c = 0; c < N; c++) {

                int student = seat[r][c];  // (r,c)에 앉은 학생
                int likeCnt = 0;           // 이 학생의 인접 좋아하는 학생 수

                // 인접 4칸 확인
                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 범위 밖이면 무시
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    // 인접한 학생이 내가 좋아하는 학생이면 likeCnt 증가
                    if (isLiked(student, seat[nr][nc])) {
                        likeCnt++;
                    }
                }

                // 좋아하는 학생 수(0~4)에 따라 점수 합산
                // score[0]=0, score[1]=1, score[2]=10, score[3]=100, score[4]=1000
                sum += score[likeCnt];
            }
        }

        return sum;
    }
}