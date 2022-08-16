package school.level2.dfsbfs;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 1차 소요시간 :
 * - 220810 30분. 배열로 트리구조 만들고 bfs 로 순회하는 스타일의 문제로 파악됨. index 계산을 아직 못 했음.
 * - 220811 60분. 풀긴 풀었다.
 *
 * 1차 후기 :
 * 애초에 트리구조를 만들고 bfs 한다는 생각부터 틀렸다.
 * 예전에 알고리즘 강의때 배웠던 배열로 트리 구조 표현하는거에 이상하게 꽂혀서 괴상한 풀이를 했다.
 * 내 접근방법은 배열로 numbers가 구성하게되는 완전이진트리를 미리 구성해놓고 이 트리를 리프노드에서 위로 거꾸로 타고 올라오면서 찾는 방법
 *
 * 아래의 모범답안들처럼 바로 bfs로 탐색해야하는 의도의 문제인데 이상하게 접근하느라 풀이도 복잡하고 시간도 더 느리다.
 * 그래도 배열로 트리구조 표현하고 순회하는 방법은 어딘가 써먹을데가 있었던 것 같다.
 *
 * 다음에는 재귀를 이용한 기본적인 dfs 로 풀어보자
 */
public class TargetNumber {
    public int solution(int[] numbers, int target) {
        // tree 생성
        int[] tree = new int[(int)Math.pow(2, numbers.length+1)-1];
        int n = 2;
        int numbersIndex = 0;
        int treeInitCnt = 0;
        for(int i=1;i<tree.length;i++) {
            treeInitCnt++;
            tree[i] = (i % 2 == 1) ? -numbers[numbersIndex] : numbers[numbersIndex];
            if(treeInitCnt == n) {
                treeInitCnt = 0;
                n *= 2;
                numbersIndex++;
            }
        }

        // 리프노드 에서 거꾸로 dfs 하며 경로 개수 찾기
        int startIndex = (int)Math.pow(2, numbers.length)-1;
        int lastIndex = tree.length -1;
        int sum = 0;

        // 정답 가지수
        int answer = 0;

        for(;startIndex <= lastIndex; startIndex++) {
            int nextIndex = startIndex;
            while(nextIndex > 0) {
                sum += tree[nextIndex];
                nextIndex = parentIndex(nextIndex);
            }
            if(sum == target) {
                answer++;
            }
            sum = 0;
        }

        return answer;
    }

    /**
     * 배열로 표현한 완전이진트리에서는 자신의 부모 노드의 인덱스를 아래 식으로 구할 수 있다.
      */
    public int parentIndex(int childIndex) {
        return childIndex - (childIndex % 2 == 0 ? childIndex / 2 + 1 : (int)Math.ceil((double)childIndex / 2));
    }

    public static void main(String[] args) {
        TargetNumber sol = new TargetNumber();

        System.out.println(sol.solution(new int[]{1,2}, 3)); // 1
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(sol.solution(new int[]{4, 1, 2, 1}, 4)); // 2
    }
}

/*
모범답안1 : 이게 내 풀이보다 당연히 속도도 잘 나온다.

class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = this.count;

        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){
            if (target == result){
                this.count++;
            }
            return;
        }

        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        dfs(numbers, depth+1, target, add);
        dfs(numbers, depth+1, target, sub);

    }
}
*/

/*
모범답안2: 모범답안1을 축약하면 아래와 같이 줄일 수 있다.

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
 */