package hackerrank.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positiveNum = 0;
        int negativeNum = 0;
        int zeroNum = 0;

        for (Integer i : arr) {
            if(i > 0) {
                positiveNum++;
            } else if(i < 0) {
                negativeNum++;
            } else {
                zeroNum++;
            }
        }

        System.out.printf("%.6f", ((double)positiveNum/arr.size()));
        System.out.println();
        System.out.printf("%.6f", ((double)negativeNum/arr.size()));
        System.out.println();
        System.out.printf("%.6f", ((double)zeroNum/arr.size()));
        System.out.println();
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
