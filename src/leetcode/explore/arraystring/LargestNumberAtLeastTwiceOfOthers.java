package leetcode.explore.arraystring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 *
 * O(2n) 으로 품. 모범답안은 O(n)이니 참고
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int largestNum = -1;
        int largestIdx = -1;
        for(int i=0;i<nums.length;i++) {
            if(largestNum < nums[i]) {
                largestNum = nums[i];
                largestIdx = i;
            }
        }

        int secondNum = -1;
        for(int i=0;i<nums.length;i++) {
            if(secondNum < nums[i] && nums[i] < largestNum) {
                secondNum = nums[i];
            }
        }

        return (largestNum >= secondNum * 2) ? largestIdx : -1;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers sol = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(sol.dominantIndex(new int[]{3,6,1,0}));  // 1
        System.out.println(sol.dominantIndex(new int[]{1,2,3,4}));  // -1
    }
}

/*
// O(n) 풀이 second 까지 한 번의 순회로 구할 수 있구나
public int dominantIndex(int[] nums) {
    int max = -1, index = -1, second = -1;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max) {
            second = max;
            max = nums[i];
            index = i;
        } else if (nums[i] > second)
            second = nums[i];
    }
    return second * 2 <= max ? index : -1;
}
 */