package school.kakao.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 성격 유형 검사하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 *
 * 소요시간 : 40분
 */
public class PersonalityCheck {
    public String solution(String[] survey, int[] choices) {
        char[][] personalArray = {{'R', 'T'},{'C','F'},{'J','M'},{'A','N'}};
        Map<Character, Integer> scoreMap = new HashMap<>();

        for(char[] array : personalArray) {
            for(char personal : array) {
                scoreMap.put(personal, 0);
            }
        }

        for (int i = 0; i < survey.length; i++) {
            String sur = survey[i];
            int choice = choices[i];
            int point = 0;
            switch (choice) {
                case 1: point = -3; break;
                case 2: point = -2; break;
                case 3: point = -1; break;
                case 5: point = 1; break;
                case 6: point = 2; break;
                case 7: point = 3; break;
            }

            if(choice < 4)
                scoreMap.put(sur.charAt(0), scoreMap.get(sur.charAt(0)) - point);
            else if(choice > 4)
                scoreMap.put(sur.charAt(1), scoreMap.get(sur.charAt(1)) + point);
        }

        String answer = "";
        for(char[] array : personalArray) {
            int score1 = Math.abs(scoreMap.get(array[0]));
            int score2 = Math.abs(scoreMap.get(array[1]));

            if(score1 < score2) {
                answer += array[1];
            } else {
                // 사전순 정렬을 겸함
                answer += array[0];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PersonalityCheck sol = new PersonalityCheck();
        System.out.println(sol.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5})); // TCMA
        System.out.println(sol.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));   // RCJA

        // 1 매우 비동의 ~ 7 매우 동의
        // 매우 3점, 그냥2점, 약간1점, 모르겠음 0점
        // -3 -2 -1 0 1 2 3
        // 획득점수가 동일하면 사전순으로 빠른거
        // 각 문항에서 0이 비동의, 1이 동의
        // "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
    }
}
