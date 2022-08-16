package school.level2.dfsbfs;

/**
 * 동일 문제 2차 시도
 * 전에 본 솔루션대로 완전이진트리를 가정하고 왼쪽, 오른쪽 서브 트리를 각각 태우는 방법을 사용함
 *
 * 소요시간 : 15분
 */
public class TargetNumber_2 {
    private int target;

    public int solution(int[] numbers, int target) {
        this.target = target;
        return dfs(numbers, 0, -1, 0) + dfs(numbers, 0, +1, 0);
    }

    public int dfs(int[] numbers, int i, int sign, int sum) {
        if(numbers.length == i+1) {
            return sum + (numbers[i] * sign) == this.target ? 1 : 0;
        }

        return dfs(numbers, i+1, -1, sum + (numbers[i] * sign))
                + dfs(numbers, i+1, +1, sum + (numbers[i] * sign));
    }

    public static void main(String[] args) {
        TargetNumber_2 sol = new TargetNumber_2();

        System.out.println(sol.solution(new int[]{1,2}, 3)); // 1
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(sol.solution(new int[]{4, 1, 2, 1}, 4)); // 2
    }
}
