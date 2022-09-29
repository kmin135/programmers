package leetcode.explore.arraystring;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
 * O(n)풀이. most vote 풀이와 유사하지만 자릿수가 늘어난 경우의 처리에서 내 풀이가 미흡했다.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int upper = 1;
        for(int i=digits.length-1;i>=0;i--) {
            int incrValue = digits[i] + upper;
            if(incrValue == 10) {
                digits[i] = 0;
                upper = 1;
            } else {
                digits[i] = incrValue;
                return digits;
            }
        }

        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(int i=0;i<digits.length;i++) {
            newDigits[i+1] = digits[i];
        }
        return newDigits;
    }

    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        System.out.println(Arrays.toString(sol.plusOne(new int[]{1,2,3}))); // 1,2,4
        System.out.println(Arrays.toString(sol.plusOne(new int[]{4,3,2,1}))); // 4,3,2,2
        System.out.println(Arrays.toString(sol.plusOne(new int[]{9}))); // 1,0
        System.out.println(Arrays.toString(sol.plusOne(new int[]{9,9,9}))); // 1,0,0,0
    }
}

/*
풀이
99
9 + 9
9 + 10
10 + 0
1 + 0 + 0
 */

/*
// 모범답안
// 문제 조건 특성상 자릿수가 늘어나는 경우는 항상 10, 100, 1000, 와 같이 10의 거듭제곱이므로 초기화후 첫번째 값만 1로 바꾸고 리턴하면된다. (java의 int 배열 초기값이 0이니까)
public int[] plusOne(int[] digits) {

    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }

        digits[i] = 0;
    }

    int[] newNumber = new int [n+1];
    newNumber[0] = 1;

    return newNumber;
}
 */