package school.level2.dfsbfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 게임 맵 최단거리 2차풀이 (bfs)
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 *
 * 소요시간3 : 35분소요 성공. bfs 로 풀이.
 */
public class GameMapShortest_2 {
    // 도달할 수 없는 경우도 있다. 이 경우 -1 반환
    // 시작점은 0, 0 / 도착점은 n-1, m-1
    // 행,열의 크기 n, m 은 서로 다를 수 있다. 범위는 [1, 100]. 단, 둘 다 1인 경우는 없다.
    // 이동은 동서남북 1칸씩
    // 해당 칸까지의 최소 거리를 별도의 동일 크기 맵에 기록한다.
    private int[][] distanceMap;
    private static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(int[][] maps) {
        distanceMap = new int[maps.length][maps[0].length];

        Deque<Coord> bfsQueue = new ArrayDeque<>();
        bfsQueue.addFirst(Coord.of(0, 0));
        distanceMap[0][0] = 1;

        while(bfsQueue.size() > 0) {
            Coord prev = bfsQueue.pollFirst();

            for(int i=0;i<direction.length;i++) {
                int nextY = prev.y + direction[i][0];
                int nextX = prev.x + direction[i][1];

                int nextDistance = distanceMap[prev.y][prev.x] + 1;
                if (cannotMove(maps, nextY, nextX, nextDistance)) {
                    continue;
                } else {
                    distanceMap[nextY][nextX] = nextDistance;
                    bfsQueue.addLast(Coord.of(nextX, nextY));

                    if(nextY == maps.length-1 && nextX == maps[0].length-1) {
                        return nextDistance;
                    }
                }
            }
        }

        return -1;
    }

    private boolean cannotMove(int[][] maps, int nextY, int nextX, int nextDistance) {
        // 맵 아웃, 막힌 곳, 이미 체크한 거리보다 거리값이 큰 곳은 갈 수 없다.
        if((nextY < 0 || nextY >= maps.length)
                || (nextX < 0 || nextX >= maps[0].length)
                || maps[nextY][nextX] == 0
                || (distanceMap[nextY][nextX] != 0 && distanceMap[nextY][nextX] <= nextDistance)) {
            return true;
        }
        return false;
    }

    static class Coord {
        int x, y;
        public static Coord of(int x, int y) {
            Coord c = new Coord();
            c.x = x;
            c.y = y;
            return c;
        }
    }

    public static void main(String[] args) {
        GameMapShortest_2 sol = new GameMapShortest_2();
        System.out.println(sol.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(sol.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }
}
