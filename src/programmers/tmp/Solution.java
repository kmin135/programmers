package programmers.tmp;

class Solution {
    public int solution(int N) {
        int srcSum = eachSum(N);

        for(int nextN = N+1;;nextN++) {
            if(srcSum == eachSum(nextN)) {
                return nextN;
            }
        }
    }

    private int eachSum(int N) {
        int sum = 0;
        int mod = 10;

        while(true) {
            int remain = N % mod;
            N = N / mod;
            sum += remain;
            if(N == 0)
                return sum;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(28)); // 37
        System.out.println(s.solution(734)); // 743
        System.out.println(s.solution(1990)); // 2089
        System.out.println(s.solution(1000)); // 10000
        // N [1,50000]
    }
}