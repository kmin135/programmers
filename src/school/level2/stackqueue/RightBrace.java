package school.level2.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 올바른 괄호
 *
 * 소요시간 : 10분
 */
public class RightBrace {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char brace : s.toCharArray()) {
            if(brace == '(') {
                stack.addLast(brace);
            } else if(brace == ')') {
                if(stack.isEmpty() || stack.pollLast() == ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        RightBrace sol = new RightBrace();
        System.out.println(sol.solution("()()")); // true
        System.out.println(sol.solution(")()(")); // false
    }
}

/*
풀이노트
열린괄호는 반드시 짝지어서 닫힌다.

1. 열림은 스택에 넣는다.
2. 닫힘을 만나면 스택에 넣지말고 pop한다.
2.1. pop한게 열림이면 ok이고 계속 반복한다.
2.2. 비어있거나 닫힘이면 잘못된 괄호이므로 즉시 종료.
 */