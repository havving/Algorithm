package org.example;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author HAVVING
 * @since 2021-08-20
 */
public class August_3 {

    public static String[][] map;
    public static boolean[][] visited;
    public static int R, C;
    public static int ans = 0;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};


    @Test
    public void al_1987() {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new String[R][C];
        visited = new boolean[R][C];

        sc.nextLine();

        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j) + "";
            }
        }
        visited[0][0] = true;
        dfs(0, 0, map[0][0], 1);

        System.out.println(ans);
    }

    public static void dfs(int x, int y, String str, int length) {
        if (ans < length) {
            ans = length;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny])
                continue;

            if (!str.contains(String.valueOf(map[nx][ny]))) {
                visited[nx][ny] = true;
                dfs(nx, ny, str + map[nx][ny], length + 1);
                visited[nx][ny] = false;
            }
        }
    }

    @Test
    public void al_2156() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] wine = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            wine[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[1] = wine[1];
        if (n > 1) {  // N = 1의 경우를 대비해 예외처리
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i < n + 1; i++) { // 전 와인과 전전 와인을 먹을 수 있는 3번째 와인부터 시작
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i]);
        }

        System.out.println(dp[n]);
    }

}
