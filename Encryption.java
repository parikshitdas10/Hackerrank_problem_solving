
//Question link https://www.hackerrank.com/challenges/encryption/problem
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

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING. The function accepts STRING s as
     * parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        s = s.replaceAll("\\s", "");
        int n = s.length();
        double sqrt = Math.sqrt(n);
        int floor = (int) Math.floor(sqrt);
        int ceil = (int) Math.ceil(sqrt);

        char space = ' ';
        if (floor * ceil < n) {
            floor = ceil;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ceil; i++) {
            int j = i;
            while (true) {
                if (j >= n) {
                    break;
                }
                str.append(s.charAt(j));
                j = j + ceil;
            }
            str.append(space);
        }
        return str.toString();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
