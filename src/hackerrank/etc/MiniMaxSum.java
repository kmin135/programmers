package hackerrank.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result2 {
    private static int[][] cheatIndex = {
            {1,2,3,4},
            {0,2,3,4},
            {0,1,3,4},
            {0,1,2,4},
            {0,1,2,3}
    };

    public static void miniMaxSum(List<Integer> arr) {
        // input이 5개라 5개중 순서상관없이 4개 뽑는 경우의수는 5C4 = 5
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(int i=0;i<cheatIndex.length;i++) {
            long subSum = 0;
            for(int j=0;j<cheatIndex[i].length;j++) {
                subSum += arr.get(cheatIndex[i][j]);
            }
            if(subSum > max) {
                max = subSum;
            }
            if(subSum < min) {
                min = subSum;
            }
        }

        System.out.println(min + " " + max);
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.miniMaxSum(arr);

        bufferedReader.close();
    }
}