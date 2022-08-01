package school.kakao.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 *
 * 소요시간 : 약 14분
 * 상세 : 정규식 안쓰고 1번 순회로 O(n)으로 풀어봄
 */
public class IntStrAndWord {
    private static Map<String, Integer> wordBook = new HashMap<>();
    static {
        wordBook.put("zero", 0);
        wordBook.put("one", 1);
        wordBook.put("two", 2);
        wordBook.put("three", 3);
        wordBook.put("four", 4);
        wordBook.put("five", 5);
        wordBook.put("six", 6);
        wordBook.put("seven", 7);
        wordBook.put("eight", 8);
        wordBook.put("nine", 9);
    }
    public static int solution(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();

        int lastNonIntIndex = -1;
        for(int i=0;i<chars.length;i++) {
            char curChar = chars[i];
            if(curChar >= '0' && curChar <= '9') {
                result.append(curChar);
            } else if(lastNonIntIndex != -1) {
                String subStr = s.substring(lastNonIntIndex, i+1);
                if(wordBook.containsKey(subStr)) {
                    result.append(wordBook.get(subStr));
                    lastNonIntIndex = -1;
                }
            } else if(lastNonIntIndex == -1) {
                lastNonIntIndex = i;
            }
        }

        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }
}
