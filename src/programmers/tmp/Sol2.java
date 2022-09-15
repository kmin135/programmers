package programmers.tmp;

public class Sol2 {
    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Sol2 s = new Sol2();
        System.out.println(s.solution(new int[]{1,1,2,3,3},3)); // true
        System.out.println(s.solution(new int[]{1,1,3},2)); // false
        System.out.println(s.solution(new int[]{0,1,2},2)); // false
        System.out.println(s.solution(new int[]{1,1,2},2)); // true
    }
}
