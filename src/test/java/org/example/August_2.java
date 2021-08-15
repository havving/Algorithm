package org.example;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class August_2 {
    public static long c;

    public static int L, C;
    public static boolean[] visited;
    public static String[] arr;
    public static ArrayList<String> list;

    public static int m;
    public static int ans = 0;
    public static boolean[] v;
    public static ArrayList<Integer>[] n_list;


    @Test
    public void al_12865() {
        Scanner in = new Scanner(System.in);

        // 물품의 수
        int n = in.nextInt();
        // 버틸수 있는 무게
        int k = in.nextInt();
        // 물품의 무게(0)와 가치(1)
        int wv[][] = new int[n + 1][2];
        // 행: 물품의 무게, 열: 1 ~ k까지의 무게, 값: 물품의 누적 가치값
        int temp[][] = new int[n + 1][k + 1];

        // 물품들의 무게와 가치 입력
        for (int i = 1; i < n + 1; i++) {
            wv[i][0] = in.nextInt();
            wv[i][1] = in.nextInt();
        }

        // 0번 행과 열은 공백으로 비워둠
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                // 비교 무게 - 물품의 무게가 0보다 클 경우,
                if (j - wv[i][0] > 0) {
                    // temp에 저장된 누적 가치와 자신의 가치+남은 무게의 가치 중 큰 값을 얻음
                    temp[i][j] = Math.max(temp[i - 1][j], wv[i][1] + temp[i - 1][j - wv[i][0]]);
                } else {
                    // 나머지는 이전 temp에 누적된 가치를 얻음
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }
        System.out.println(temp[n][k]);
        in.close();
    }


    @Test
    public void al_1655() {
        Scanner scan = new Scanner(System.in);

        // 우선순위 큐
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int n = scan.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();

            // 최대/최소 우선순위 큐의 크기가 같으면, 최대 큐에 숫자 입력
            if (minHeap.size() == maxHeap.size()) maxHeap.add(num);
            else minHeap.add(num);

            // 최대/최소 우선순위 큐가 비어있지 않고, 최대 큐의 루트값이 더 크면 최소 큐의 루트값과 자리 바꿈
            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
    }


    @Test
    public void al_1629() {
        Scanner in = new Scanner(System.in);

        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        System.out.println(pow(a, b));
    }

    public long pow(long a, long exponent) {

        // 지수가 1일 경우, a^1 이므로 a를 그대로 리턴
        if (exponent == 1) {
            return a % c;
        }

        // 지수의 절반에 해당하는 a^(b/2)를 구함
        long temp = pow(a, exponent / 2);

        /*
         * 현재 지수가 홀수라면,
         * a^(exponent / 2) * a^(exponent / 2) * a 이므로
         * a를 한번 더 곱해주어야 함
         *
         * ex) a^9 = a^4 * a^4 * a
         */
        if (exponent % 2 == 1)
            return (temp * temp % c) * a % c;

        return temp * temp % c;
    }


    @Test
    public void al_1759() {
        Scanner in = new Scanner(System.in);

        // l개의 알파벳 소문자들
        L = in.nextInt();
        // 암호로 사용 가능한 문자의 종류
        C = in.nextInt();
        in.nextLine();

        String str = in.nextLine();
        arr = str.split(" ");
        Arrays.sort(arr);

        visited = new boolean[C];
        list = new ArrayList<>();
        combination(0, L);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i) + "\n");

        System.out.println(sb);
    }

    // 조합 백트래킹으로 구현
    private void combination(int start, int r) {
        if (r == 0) {
            int[] alpha = new int[123];
            String result = "";

            for (int i = 0; i < c; i ++) {
                if (visited[i]) {
                    result += arr[i];
                    alpha[arr[i].charAt(0)]++;
                }
            }

            // 모음 개수
            int vowels = alpha['a'] + alpha['e'] + alpha['i'] + alpha['o'] + alpha['u'];
            // 자음 개수
            int consonants = L - vowels;

            if (vowels >= 1 && consonants >= 2)
                list.add(result);
            return;
        } else {
            for (int i = start; i < C; i++) {
                visited[i] = true;
                combination(i+1, r-1);
                visited[i] = false;
            }
        }
    }


    @Test
    public void al_13023() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        m = M;

        // DFS를 위한 인접 리스트 구현
        n_list = new ArrayList[N];
        v = new boolean[N];
        for (int i = 0; i < M; i++)
            n_list[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            n_list[n1].add(n2);
            n_list[n2].add(n1);
        }

        // N-1 까지의 모든 정점에서 DFS를 통해 확인
        for (int i = 0; i < N; i++) {
            if (ans == 0) dfs(i, 1);
        }

        bw.write(Integer.toString(ans));;
        bw.flush();
        bw.close();
        br.close();
    }

    public void dfs(int start, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }

        v[start] = true;
        for (int i : n_list[start]) {
            int next = i;
            if (!v[next])
                dfs(next, depth+1);
        }
        v[start] = false;
    }

}