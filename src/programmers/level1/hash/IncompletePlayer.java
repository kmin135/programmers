package programmers.level1.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 소요시간 : 15분
 */
public class IncompletePlayer {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        for(String name : participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }

        for(String name : completion) {
            Integer nextCount = participantMap.get(name) - 1;

            if(nextCount == 0) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, nextCount);
            }
        }
        // 문제 조건에 따라 반드시 1개 key만 남음
        for(String key : participantMap.keySet()) {
            return key;
        }
        return "WRONG";
    }

    public static void main(String[] args) {
        IncompletePlayer ip = new IncompletePlayer();
        System.out.println(ip.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
}

/*
풀이노트

1. 참가자 맵을 만든다. 참가자명 String, 참가수 Integer.
2. 완주자를 순회하며 참가자맵의 참가수 값을 decrement 하는데 0이되면 맵에서 뺀다.
3. 2까지 완료하면 참가자맵에는 1개 key만이 남으며 이 참가자명이 답이된다.
 */