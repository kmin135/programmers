package leetcode.explore.arraystring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 *
 * 풀이 : 바로 생각할 수 있는 O(n^2) 풀이
 * 아래에 O(n) 풀이도 넣어두었으니 참고
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {

        for(int i=0;i<nums.length;i++) {
            int leftSum = 0;
            for(int left=0;left<i;left++) {
                leftSum += nums[left];
            }

            int rightSum = 0;
            for(int right=i+1;right<nums.length;right++) {
                rightSum += nums[right];
            }

            if(leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex sol = new FindPivotIndex();
        System.out.println(sol.pivotIndex(new int[]{1,7,3,6,5,6})); // 3
        System.out.println(sol.pivotIndex(new int[]{1,2,3})); // -1
        System.out.println(sol.pivotIndex(new int[]{2,1,-1})); // 0, 양끝도 pivot index가 될 수 있음
    }
}

/*
// O(n) 풀이
public int pivotIndex(int[] nums) {
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) totalSum += nums[i];
    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        if (leftSum == totalSum-(leftSum)-nums[i]) return i;
        leftSum += nums[i];
    }
    return -1;
}
 */