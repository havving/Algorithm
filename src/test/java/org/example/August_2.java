package org.example;

import org.junit.Test;

import java.util.Scanner;

public class August_2 {

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


}