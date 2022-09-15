package programmers.level1.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 *
 * 소요시간 : 25분
 * */
public class TestExam {
    /*
    1번 수포자가 찍는 방식: [1, 2, 3, 4, 5], 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: [2, 1, 2, 3, 2, 4, 2, 5], 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5], 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     */
    private static int[][] studentPatterns = {
            {1, 2, 3, 4, 5}
            ,{2, 1, 2, 3, 2, 4, 2, 5}
            ,{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public static int[] solution(int[] answers) {
        int[] studentAnswerCnts = {0, 0, 0};

        for(int i=0;i<answers.length;i++) {
            for(int j=0;j<studentPatterns.length;j++) {
                if(studentPatterns[j][i % studentPatterns[j].length] == answers[i]) {
                    studentAnswerCnts[j]++;
                }
            }
        }

        int maxAnswerCnt = 0;
        for(int i=0;i<studentAnswerCnts.length;i++) {
            if(maxAnswerCnt < studentAnswerCnts[i]) {
                maxAnswerCnt = studentAnswerCnts[i];
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<studentAnswerCnts.length;i++) {
            if(maxAnswerCnt == studentAnswerCnts[i]) {
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
    }
}
