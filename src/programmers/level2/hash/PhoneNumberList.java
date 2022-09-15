package programmers.level2.hash;

import java.util.Arrays;

/**
 * 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 *
 * 소요시간 : 15분
 * 노트 : 해시문제인데 조건 특성상 정렬 후 startWith만으로 풀림.
 */
public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++) {
            String curr = phone_book[i];
            String next = phone_book[i+1];

            if(next.startsWith(curr)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PhoneNumberList sol = new PhoneNumberList();
        System.out.println(sol.solution(new String[]{"119", "97674223", "1195524421"}));
    }
}

/*
풀이 노트

1. 전화번호에 중복은 없다.
2. 정렬을 하면 앞의 숫자가 작은게 앞에온다.
3. 정렬한 배열을 앞에서부터 순회하면서 다음게 이전걸로 시작하는지 확인 -> 1개라도 해당하면 return false
    순회종료까지 못 찾으면 return true
 */