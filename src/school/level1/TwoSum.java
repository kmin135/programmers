package school.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 두 개 뽑아서 더하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=java
 *
 * 소요시간 : 약 10분
 * 개선포인트 : j=0으로 완전 O(N^2)로 했는데 앞에 것은 중복 계산할 필요가 없으므로 j=i+1로 상수 최적화 가능
 */
public class TwoSum {
    public int[] solution(int[] numbers) {
        Set<Integer> sumSet = new TreeSet<>();

        for(int i=0;i<numbers.length;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                if(i == j) continue;

                sumSet.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[sumSet.size()];
        int index = 0;
        for(Integer sum : sumSet) {
            answer[index++] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        System.out.println(Arrays.toString(sol.solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{5,0,2,7})));
    }
}
