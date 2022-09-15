package programmers.level2.bruteforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 소수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 *
 * 소요시간 : 40분
 * 코멘트 : 순열 탐색과 소수 체크 결합문제. 순열 계산과 소수체크 양쪽 모두 더 최적화 가능 (하단 모범답안 참고)
 */
public class FindPrimeNumber {
    private Set<Integer> candidates;
    public int solution(String numbers) {
        candidates = new HashSet<>();
        int answer = 0;

        for(int i=1;i<=numbers.length();i++) {
            search(numbers, "", i, new int[]{});
        }

        Iterator<Integer> iterator = candidates.iterator();
        while(iterator.hasNext()) {
            if(!isPrime(iterator.next())) {
                iterator.remove();
            }
        }

        return candidates.size();
    }

    private boolean isPrime(int candidate) {
        if(candidate <= 1) return false;

//        for(int i=2;i<candidate;i++) {
        // 자신의 제곱근(포함)까지만 나눠보면 소수를 판별할 수 있다.
        for(int i=2;i<=(int)Math.sqrt(candidate);i++) {
            if(candidate % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void search(String numbers, String current, int len, int[] searchedIdx) {
        // 탐색 종료
        if(current.length() == len) {
            candidates.add(Integer.parseInt(current));
            return;
        };

        for(int i=0;i<numbers.length();i++) {
            if(isAlreadyAdd(searchedIdx, i)) {
                continue;
            } else {
                int[] newSearched = Arrays.copyOf(searchedIdx, searchedIdx.length+1);
                newSearched[newSearched.length-1] = i;
                search(numbers, current + numbers.charAt(i), len, newSearched);
            }
        }
    }

    private boolean isAlreadyAdd(int[] searchedIdx, int target) {
        for(int search : searchedIdx) {
            if(search == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindPrimeNumber sol = new FindPrimeNumber();
        System.out.println(sol.solution("17")); //3 - 7, 17, 71
        System.out.println(sol.solution("011")); //2 - 11, 101
    }
}

/*
풀이노트
1. 가능한 모든 수의 조합 탐색 (0이 맨 앞에 올 때 주의, 중복도 제거해야함, 카운트를 세지말고 set에 넣는것도 방법일듯)
- 모든 수를 다 써야하는게 아니고 1자리, 2자리, ... n자리까지의 모든 조합임
2. 각 수가 소수일 경우 카운트 증가
3. 탐색 종료 후의 최종 카운트가 정답

--

1. 가능한 모든 수의 조합을 set으로 만든다
2. 순회하면서 소수가 아닌수를 set에서 제거한다.
3. set의 최종크기가 정답이된다.

123

1 - 1,2,3 (3P1) - 3
2 - 12,13,21,23,31,32 (3P2) - 6
3 - 123,132,213,231,312,321 (3P3) - 6

numbers의 최대길이는 7. 최대 set의 크기는...
7P1 + 7P2 + 7P3 + 7P4 + 7P5 + 7P6 + 7P7

가능한 가장 큰 수는 9999999 에스테라 어쩌구 체

2로 나눠지는 수 제외
 */


/*
인터넷 모범답안

1. 순열을 구하는 로직이 깔끔함
2. 소수체크도 짝수는 먼저 걸러버리고 홀수만 체크하고 있음. 제곱근까지만 계산하는 것도 포인트.

import java.util.HashSet;
class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
    }

}

 */