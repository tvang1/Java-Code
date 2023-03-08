import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class hackerrank_if_else {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println("Enter a number: ");
        //int N = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0;i<1;i++){
            if (i==0){
                System.out.println(i+" is Weird");
            }
            else if ( (i%2) >=1 ){
                System.out.println(i+" is Weird");
            }
            else if (i>=2 && i<=5 ){
                System.out.println(i+" is Not Weird");
            }
            else if (i>=6 && i<=20){
                System.out.println(i+" Weird");
            }
            else if ( i>20 ){
                System.out.println(i+" Not Weird");
            }
        }

        //scanner.close();
    }
}
