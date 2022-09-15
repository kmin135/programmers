package programmers.kakao.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문자열압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 *
 * 소요시간 : 45분
 *
 * 튜닝 : 처음에는 substrLength<s.length() 로 순회했는데 원래 문자열 절반 초과로는 볼 필요없으므로
 *   substrLength <= s.length()/2
 */
public class StringCompress {
    public static int solution(String s) {
        int finalTotalLength = s.length();

        for(int substrLength=1;substrLength <= s.length()/2;substrLength++) {
            // 길이 n의 char배열을 list로 만든다.
            List<char[]> list = splitToList(s, substrLength);

            // 앞에서부터 압축 길이를 센다. (압축된 문자열을 꼭 만들필요는 없다.)
            int compress = 1;
            char[] before = list.get(0);
            char[] current = null;
            int totalLength = 0;
            for (int i = 1; i < list.size(); i++) {
                current = list.get(i);
                if (isEquals(before, current)) {
                    compress++;
                } else {
                    totalLength += getTotalLength(compress, before);
                    compress = 1;
                    before = current;
                }
            }
            totalLength += getTotalLength(compress, current);

            finalTotalLength = (finalTotalLength > totalLength) ? totalLength : finalTotalLength;
        }

        return finalTotalLength;
    }

    private static int getTotalLength(int compress, char[] current) {
        return (compress > 1 ? String.valueOf(compress).length() : 0) + current.length;
    }

    private static boolean isEquals(char[] before, char[] current) {
        if(before.length != current.length) return false;

        for(int i=0;i<before.length;i++) {
            if(before[i] != current[i]) return false;
        }
        return true;
    }

    private static List<char[]> splitToList(String s, int size) {
        List<char[]> result = new ArrayList<>();
        for(int i=0;i<s.length();i+=size) {
            result.add(Arrays.copyOfRange(s.toCharArray(), i, Math.min(i+size, s.length())));
        }
        return result;
    }

    public static void main(String[] args) {
        // 특정 길이 N으로 앞에서부터 쪼갤 수 있다. 마지막 부분문자열은 N보다 작을 수 있다.
        // 8자리만 1,2,4 = 즉, 원래 길이를 나눌 수 있는 수 / 반면에 8은 그냥 원래 문자열 길이 반환
        System.out.println(solution("aabbaccc")); //7
        System.out.println(solution("ababcdcdababcdcd")); //9
        System.out.println(solution("abcabcdede")); //8
        System.out.println(solution("abcabcabcabcdededededede")); //14
        System.out.println(solution("xababcdcdababcdcd")); //17
    }
}
