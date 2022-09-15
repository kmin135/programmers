package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 *
 * 소요시간 : 1차 35분
 * 상세 : 작업별 남은 시간을 먼저 계산해두고 이를 순회하여 정답을 얻음 O(n)
 */
public class FunctionDevelopment {
    private static int remainDay(int remainWork, int workSpeedPerDay) {
        int day = remainWork / workSpeedPerDay;
        int remain = remainWork % workSpeedPerDay;
        return remain > 0 ? day + 1 : day;
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] firstReleaseDays = new int[progresses.length];
        for(int i=0;i<progresses.length;i++) {
            firstReleaseDays[i] = remainDay(100-progresses[i], speeds[i]);
        }

        List<Integer> functionCntPerRelease = new ArrayList<>();

        int lastValue = firstReleaseDays[0];
        int releaseCnt = 1;
        for(int i=1;i<firstReleaseDays.length;i++) {
            if(firstReleaseDays[i] <= lastValue) {
                releaseCnt++;
            } else {
                functionCntPerRelease.add(releaseCnt);
                releaseCnt = 1;
                lastValue = firstReleaseDays[i];
            }
        }
        functionCntPerRelease.add(releaseCnt);

//        int[] answer = new int[functionCntPerRelease.size()];
//        int idx = 0;
//        for(int i : functionCntPerRelease) {
//            answer[idx++] = i;
//        }
        // stream 방식으로 int 배열로 변환하니 0.05ms -> 2.00ms 정도로 시간이 증가함
        // 가독성과 성능 트레이드오프
        return functionCntPerRelease.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93,30,55}, new int[]{1,30,5})));
        System.out.println(Arrays.toString(solution(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1})));

        // mod값을 이용해서 구분
//        System.out.println(remainDay(5, 45));
    }
}
