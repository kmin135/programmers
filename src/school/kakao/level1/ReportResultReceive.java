package school.kakao.level1;

import java.util.*;

/**
 * 신고 결과 받기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 *
 * 소요시간 : 약 30분
 */
public class ReportResultReceive {
    public static int[] solution(String[] id_list, String[] report, int k) {
        // 1. 유저별로 신고횟수 Set을 저장 (중복제거)
        // 유저1 - 신고대상1, 신고대상2
        Map<String, Set<String>> mapForUserReport = new HashMap<>();
        for(String id : id_list) {
            mapForUserReport.put(id, new HashSet<>());
        }

        for(String oneReport : report) {
            String[] userMapping = oneReport.split(" ");
            String reportUser = userMapping[0];
            String targetUser = userMapping[1];
            mapForUserReport.get(reportUser).add(targetUser);
        }

        // 2. 모든 유저의 신고횟수 set을 순회하여 신고횟수가 k이상인 유저 명단 생성 (알림명단)
        Map<String, Integer> reportCntPerUser = new HashMap<>();
        mapForUserReport.forEach((key, value) -> {
            value.forEach(targetUser -> {
                if(reportCntPerUser.containsKey(targetUser)) {
                    reportCntPerUser.put(targetUser, reportCntPerUser.get(targetUser)+1);
                } else {
                    reportCntPerUser.put(targetUser, 1);
                }
            });
        });

        // 3. 유저별로 알림명단의 보유수를 세어 int[유저수] 배열로 생성
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++) {
            String reportUser = id_list[i];
            for (String targetUser : mapForUserReport.get(reportUser)) {
                if(reportCntPerUser.getOrDefault(targetUser, -1) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(
                solution(new String[]{"muzi", "frodo", "apeach", "neo"}
                ,new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
                ,2)
            )
        );

        System.out.println(
                Arrays.toString(
                        solution(new String[]{"con", "ryan"}
                                ,new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}
                                ,3)
                )
        );
    }
}
