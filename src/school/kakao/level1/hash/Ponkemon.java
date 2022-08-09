package school.kakao.level1.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 폰케몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *
 * 소요시간 : 10분
 */
public class Ponkemon {
    public static int solution(int[] nums) {
        // 몇 마리 고를 수 있나? nums는 항상 짝수
        int howMari = nums.length / 2;

        Set<Integer> categorySet = new HashSet<>();
        for (Integer category : nums) {
            categorySet.add(category);
        }

        return howMari <= categorySet.size() ? howMari : categorySet.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
    }
}
