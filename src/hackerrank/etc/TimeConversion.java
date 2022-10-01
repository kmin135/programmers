package hackerrank.etc;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result3 {

    /*
     * 12:00:00AM -> 00:00:00
     * 01:00:00AM -> 01:00:00
     * 12:00:00PM -> 12:00:00
     * 07:05:45PM -> 19:05:45
     */

    public static String timeConversion(String s) {
        boolean isAmOrElse = s.contains("AM");
        String hour = s.substring(0, 2);
        String right = s.substring(2, 8);

        if("12".equals(hour)) {
            hour = isAmOrElse ? "00" : "12";
        } else {
            hour = isAmOrElse ? hour : String.valueOf(Integer.parseInt(hour)+12);
        }

        return hour+right;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result3.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
