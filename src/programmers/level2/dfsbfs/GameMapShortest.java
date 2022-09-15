package programmers.level2.dfsbfs;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 *
 * 소요시간1 : 55분 dfs로 풀다가 효율성 테스트에서 실패. -> 다른 의견보니 bfs가 맞는듯.
 * 소요시간2 : 15분정도 bfs 로 바꿔볼까 하다가 생각안나서 일단 중단. 큐를 도입해서 재도전해보자.
 */
public class GameMapShortest {
    // 도달할 수 없는 경우도 있다. 이 경우 -1 반환
    // 시작점은 0, 0 / 도착점은 n-1, m-1
    // 행,열의 크기 n, m 은 서로 다를 수 있다. 범위는 [1, 100]. 단, 둘 다 1인 경우는 없다.
    // 이동은 동서남북 1칸씩
    // 해당 칸까지의 최소 거리를 별도의 동일 크기 맵에 기록한다.
    private int[][] distanceMap;
    public int solution(int[][] maps) {
        distanceMap = new int[maps.length][maps[0].length];

        dfs(maps, 0, 0, 1);
        if(distanceMap[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        }
        return distanceMap[maps.length-1][maps[0].length-1];
    }

    public void dfs(int[][] maps, int y, int x, int distance) {
        if(
                // 맵 범위를 나감
                (y < 0 || y >= maps.length) || (x < 0 || x >= maps[0].length)
                // 막혔음
                || maps[y][x] == 0
                // 이전에 탐색한 거리보다 크거나 같아서 더 볼 필요가 없음
                || (distanceMap[y][x] != 0 && distanceMap[y][x] <= distance)
                // 이미 찾은 경로보다 길어서 더 볼 필요가 없음
                || (distanceMap[maps.length-1][maps[0].length-1] != 0 && distanceMap[maps.length-1][maps[0].length-1] <= distance)
        ) {
            return;
        }
        if(y == maps.length-1 && x == maps[0].length-1) {
            distanceMap[y][x] = distance;
            return;
        }

        distanceMap[y][x] = distance;

        // 동 서 남 북
        dfs(maps, y, x+1, distance+1);
        dfs(maps, y, x-1, distance+1);
        dfs(maps, y+1, x, distance+1);
        dfs(maps, y-1, x, distance+1);
    }

    public static void main(String[] args) {
        GameMapShortest sol = new GameMapShortest();
//        System.out.println(sol.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(sol.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }
}
