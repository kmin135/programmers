package school.level2;

/**
 * 124 나라의 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899
 *
 * 소요시간 : 약 100+30분
 * - 220803 : 100분 시도 후 실패. 3진법을 기본으로 접근하는 건 알겠고 손으로 풀 수도 있는데 코드로 옮기는데 실패함.
 * - 220804  :30분으로 성공. 단순 3진법이 아니라 나머지가 0일 때의 특수한 연산이 필요한 문제.
 * 상세 : 숫자의 규칙을 찾아내어 코드로 옮기는 문제. 아이디어가 중요한 문제같다.
 */
public class Country124 {
    private static final int BASE = 3;
    private static char convert(int num) {
        if(num == 3) return '4';
        if(num == 2) return '2';
        return '1';
    }
    public static String solution(int n) {
        StringBuilder result = new StringBuilder();

        int mok = n;

        do  {
            n = mok;
            mok = n / BASE;
            int remain = n % BASE;

            if(remain == 0) {
                mok--;
                remain += BASE;
            }

            result.insert(0, convert(remain)).insert(0, mok > 0 && mok <= BASE ? convert(mok) : "");
        } while(mok > BASE);

        return result.toString();
    }

    public static void main(String[] args) {
        for(int i=1;i<=40;i++) {
            System.out.println(solution(i));
        }
    }

    /*
    1. 3진법으로 변환하되
    2. 나머지가 0 일때 몫-1, 나머지+3 한 뒤 연산을 계속하는것이 포인트
    3. String concat 연산이므로 StringBuilder로 속도최적화
    4. 추가로 3진법이지만 3을 4로 표시하는 것도 필요
     */
}
