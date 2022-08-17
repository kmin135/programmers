package school.level1.bruteforce;

/**
 * 최소 직사각형
 * https://school.programmers.co.kr/learn/courses/30/parts/12230
 *
 * 소요시간 : 10분
 */
public class MinRectangle {
    // [w][h] w : 가로, h : 세로
    public int solution(int[][] sizes) {
        // 각 명함을 모두 세운다. 즉 [14, 4]면 -> [4, 14] 로 세우고, [3, 10] 이면 이미 세워져있으므로 그냥 둔다
        // 모든 명함중에서 가장 큰 가로 * 가장 큰 세로의 결과가 답이다.
        int maxW = -1;
        int maxH = -1;
        for(int i=0;i< sizes.length;i++) {
            if(sizes[i][0] > sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            maxW = (maxW < sizes[i][0]) ? sizes[i][0] : maxW;
            maxH = (maxH < sizes[i][1]) ? sizes[i][1] : maxH;
        }

        return maxW * maxH;
    }

    public static void main(String[] args) {
        MinRectangle s = new MinRectangle();

        System.out.println(s.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // 4000
        System.out.println(s.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120
        System.out.println(s.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); // 133
    }
}
