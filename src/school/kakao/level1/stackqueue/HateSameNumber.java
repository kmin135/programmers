package school.kakao.level1.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 *
 * 소요시간 : 15분
 */
public class HateSameNumber {
    public static int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(arr[0]);

        for(int i=1;i<arr.length;i++) {
            if(stack.peekLast() != arr[i]) {
                stack.addLast(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty()) {
            answer[idx++] = stack.pollFirst();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));
        System.out.println(Arrays.toString(solution(new int[]{4,4,4,3,3})));
    }
}
