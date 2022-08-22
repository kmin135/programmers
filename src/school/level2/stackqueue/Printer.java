package school.level2.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 프린터
 *
 * 소요시간 : 20분
 *
 * 더 좋은 풀이 : 모범풀이를 보면 나처럼 maxNumber 를 계속 계산하는게 아니라
 * priorities 를 별도로 정렬해두고 끝에서부터 빠지는걸 이용한 풀이가 있다.
 */
public class Printer {
    public int solution(int[] priorities, int location) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int priority : priorities) {
            queue.addLast(priority);
        }

        int answer = 0;
        int maxNumber = getMaxNumber(queue);
        while(!queue.isEmpty()) {
            Integer headNumber = queue.pollFirst();

            if(maxNumber > headNumber) {
                queue.addLast(headNumber);
                location--;
                if(location == -1) {
                    location = queue.size() - 1;
                }
            } else {
                answer++;
                location--;
                if(location == -1) {
                    return answer;
                }
                maxNumber = getMaxNumber(queue);
            }
        }

        return answer;
    }

    private int getMaxNumber(Deque<Integer> queue) {
        int maxNumber = -1;
        for(Integer num : queue) {
            maxNumber = num > maxNumber ? num : maxNumber;
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        Printer sol = new Printer();
        System.out.println(sol.solution(new int[]{2,1,3,2}, 2)); // 1
        System.out.println(sol.solution(new int[]{1,1,9,1,1,1}, 0)); // 5
    }
}

/*
풀이노트
최초 location을 식별할 수 있어야함. 아니면 위치가 동기되도록 해도되고..
 */