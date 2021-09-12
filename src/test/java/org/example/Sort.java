package org.example;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HAVVING
 * @since 2021-09-12
 */
public class Sort {

    @Test
    public void bubbleSort() {
        int[] arr = new int[]{15, 7, 3, 8, 42, 5};
        System.out.println("정렬 전 : " + Arrays.toString(arr));

        // 배열 원소를 담아둘 변수
        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                // 앞의 원소가 뒤의 원소보다 클 경우 swap
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];    // 앞의 원소를 temp에 담고
                    arr[j - 1] = arr[j];    // 앞의 원소에 뒤의 값(더 작은 값)을 담음
                    arr[j] = temp;    // 뒤의 값 자리에는 앞의 값(더 큰값)을 담아 swap완료
                }
            }
        }
        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }

    @Test
    public void selectionSort() {
        int[] arr = new int[]{11, 17, 36, 5, 42, 1};
        System.out.println("정렬 전 : " + Arrays.toString(arr));

        // 선택한 위치, 배열 원소를 담아둘 변수
        int indexMin, temp;

        for (int i = 0; i < arr.length-1; i++) {
            indexMin = i;	// 위치 선택
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[indexMin] > arr[j]) {	// 선택한 위치의 원소가 다음 원소보다 클 경우
                    indexMin = j;		// 선택한 위치값 갱신.. 최소값을 찾는 과정
                }
            }

            // arr[indexMin], arr[i] swap
            temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
            System.out.println((i+1)+"회전 : " + Arrays.toString(arr));
        }

        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }

    @Test
    public void insertionSort() {
        int[] arr = new int[]{13, 7, 33, 21, 4, 8, 11};
        System.out.println("정렬 전 : " + Arrays.toString(arr));

        // 두 번째 원소부터 시작하므로 index = 1
        for (int index = 1; index < arr.length; index++) {
            int temp = arr[index];
            int prev = index - 1;

            // 현재 비교하는 원소보다 앞에 있는 모든 원소들과 비교
            while(prev >= 0 && (arr[prev] > temp)) {
                arr[prev + 1] = arr[prev];	// 큰 값을 뒤로 이동
                prev--;
            }

            // prev는 현재 비교하는 원소보다 작은 값 중 가장 큰 값의 index이므로 바로 뒤에 현재 원소값을 삽입
            arr[prev + 1] = temp;
            System.out.println(index +"회전 : " + Arrays.toString(arr));
        }
        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }
}
