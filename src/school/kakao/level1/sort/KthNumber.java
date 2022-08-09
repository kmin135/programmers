package school.kakao.level1.sort;

import java.util.Arrays;

/**
 * K번째수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 *
 * 소요시간 : 약 10분
 */
public class KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
        // commands[0] = {2, 5, 3}, commands[0][1] = 5
        int[] answer = new int[commands.length];

        for(int index=0;index<commands.length;index++) {
            int[] params = commands[index];
            int i = params[0];
            int j = params[1];
            int k = params[2];

            int[] subArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(subArr);
            answer[index] = subArr[k-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
