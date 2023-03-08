import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* Print results of a multiplication to 10 of a number.
 * Where: N x i = Result
 */

public class hackerrank_loop1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        int sum;

        for (int i=1;i<11;i++){
            sum = N*i;

            System.out.println(N+" x "+i+" = "+sum);

        }

        bufferedReader.close();
    }
}
