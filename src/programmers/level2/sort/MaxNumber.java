package programmers.level2.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 *
 * 1차시도 : 1시간20분 실패. 미리 숫자길이를 맞춘다는 기본 아이디어로 접근했는데 1~6번, 11번이 틀리고 사람들이 만든 반례 발견해서 하나 고쳤더니 다른게 틀리고...
 *   규칙을 완벽히 파악하지 않고 어설프게 시작한뒤 어설픈 답안으로 반례를 땜빵하다보니 이도저도 아니게됐다.
 *   규칙을 다시 파악한뒤 재시도해보자
 *
 * 2차시도 : 30분 성공. 1차시도에서 계속 삽질하다가 갑자기 떠올라서 풀렸다.
 *   두 수를 순서를 바꿔서 concat 했을때의 결과중 큰 수로 내림차순 정렬하고 정렬한 리스트를 join하면 된다.
 *   또한 시작이 0이라는 것은 가장 큰 조합이 0으로 시작한다 = 결과가 0인 것이므로 예외처리하고
 *   그 외에는 result가 항상 0이 아닌 수로 시작하므로 그대로 리턴한다.
 */
public class MaxNumber {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        for(int num : numbers) {
            nums.add(String.valueOf(num));
        }

        nums.sort((n1, n2) -> -(Integer.parseInt(n1 + n2) - Integer.parseInt(n2 + n1)));

        String result = nums.stream().collect(Collectors.joining());
        return result.charAt(0) == '0' ? "0" : result;
    }

    public static void main(String[] args) {
        MaxNumber sol = new MaxNumber();
        System.out.println(sol.solution(new int[]{6,10,2}));        // 6210
        System.out.println(sol.solution(new int[]{3,30,34,5,9}));   // 9534330
        System.out.println(sol.solution(new int[]{3, 303}));   // 3303
        System.out.println(sol.solution(new int[]{3, 339}));   // 3393
        System.out.println(sol.solution(new int[]{101, 10, 232, 23}));   // 2323210110
        System.out.println(sol.solution(new int[]{1, 10, 100, 1000}));   // 3303
        System.out.println(sol.solution(new int[]{0, 0, 1, 0, 0}));   // 3303
        System.out.println(sol.solution(new int[]{0, 0, 0, 0}));   // 3303
        System.out.println(sol.solution(new int[]{10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));   // 3303
        System.out.println(sol.solution(new int[]{412, 41}));   // 41 412
        System.out.println(sol.solution(new int[]{402, 41}));   // 41 402
    }
}

/*
풀이노트

n1, n2

n1n2 와 n2n1을 비교하여 정렬하면된다.
 */