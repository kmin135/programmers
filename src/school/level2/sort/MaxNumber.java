package school.level2.sort;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 *
 * 1차시도 : 1시간20분 실패. 미리 숫자길이를 맞춘다는 기본 아이디어로 접근했는데 1~6번, 11번이 틀리고 사람들이 만든 반례 발견해서 하나 고쳤더니 다른게 틀리고...
 *   규칙을 완벽히 파악하지 않고 어설프게 시작한뒤 어설픈 답안으로 반례를 땜빵하다보니 이도저도 아니게됐다.
 *   규칙을 다시 파악한뒤 재시도해보자
 */
public class MaxNumber {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        for(int num : numbers) {
            nums.add(String.valueOf(num));
        }

        nums.sort((o1, o2) -> {
            if(o1.length() > o2.length()) {
//                int extraLen = o1.length() - o2.length();
//                char lastChar = o2.charAt(o2.length()-1);
//                for(int i=0;i<extraLen;i++) {
//                    o2 = o2 + lastChar;
//                }
                String org2 = o2;
                while(o1.length() > o2.length()) {
                    o2 += org2;
                }
                o2 = o2.substring(0, o1.length());
            } else if(o1.length() < o2.length()) {
//                int extraLen = o2.length() - o1.length();
//                char lastChar = o1.charAt(o1.length()-1);
//                for(int i=0;i<extraLen;i++) {
//                    o1 = o1 + lastChar;
//                }
                String org1 = o1;
                while(o1.length() < o2.length()) {
                    o1 += org1;
                }
                o1 = o1.substring(0, o2.length());
            }

            for(int i=0;i<o1.length();i++) {
                if(o1.charAt(i) != o2.charAt(i)) {
                    return -(o1.charAt(i) - o2.charAt(i));
                }
            }

            return 0;
        });

        return new BigInteger(nums.stream().collect(Collectors.joining())).toString();
    }

    public static void main(String[] args) {
        MaxNumber sol = new MaxNumber();
//        System.out.println(sol.solution(new int[]{6,10,2}));        // 6210
//        System.out.println(sol.solution(new int[]{3,30,34,5,9}));   // 9534330
//        System.out.println(sol.solution(new int[]{3, 303}));   // 3303
//        System.out.println(sol.solution(new int[]{3, 339}));   // 3393
        System.out.println(sol.solution(new int[]{101, 10, 232, 23}));   // 2323210110
//        System.out.println(sol.solution(new int[]{1, 10, 100, 1000}));   // 3303
//        System.out.println(sol.solution(new int[]{0, 0, 1, 0, 0}));   // 3303
//        System.out.println(sol.solution(new int[]{0, 0, 0, 0}));   // 3303
//        System.out.println(sol.solution(new int[]{10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));   // 3303
//        System.out.println(sol.solution(new int[]{412, 41}));   // 41 412
//        System.out.println(sol.solution(new int[]{402, 41}));   // 41 402
    }
}

/*
풀이노트
1000 999
1 12 112
33
334
3
339
0 1000
3 339
339 3 -> 이게 더 큼!

3   -> 333
339 -> 339

10
102

3 303 3033 3303
1. 자리수 상관없이 맨 앞의 수가 더 큰게 우선
-> 오히려 1, 9, 91 이 있다면 9, 91 ,1 이 91, 9, 1 보다 크다 3 34 / 343
-> 3, 34라면 34, 3이 더 크다
-> 3, 33이라면 상관없다
-> 3, 32이라면 3, 32이 더 크다
2. 자체 comparator 를 만들어야한다.
 */