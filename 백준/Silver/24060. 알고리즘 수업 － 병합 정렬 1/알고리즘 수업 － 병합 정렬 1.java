import java.io.*;
import java.util.*;

class Main {

    static int[] A;
    static int[] tmp;
    static int N;
    static int K;
    static int count = 0;
    static int answer = -1;

    public static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    public static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t] = A[i];
                t++;
                i++;
            } else {
                tmp[t] = A[j];
                t++;
                j++;
            }
        }

        while (i <= q) {
            tmp[t] = A[i];
            t++;
            i++;
        }

        while (j <= r) {
            tmp[t] = A[j];
            t++;
            j++;
        }

        i = p;
        t = 0;

        while (i <= r) {
            A[i] = tmp[t];
            count++;
            if (count == K) {
                answer = A[i];
            }
            i++;
            t++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}