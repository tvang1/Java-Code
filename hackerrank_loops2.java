import java.util.*;
import java.io.*;
import java.math.*;

/* A loop that does a series loop of:
 * (a+(2^j)*b) + (a+(2^j+1)*b) + (a+(2^j+2)*b) + (a+(2^j+1)*b) ... 
 * 
 * Where q determines how many queries and n how many series to do.
 * 
 * An initial is done for the 2^0 and is stored in init. Where it is printed first.
 * Curr then represents the newer sums and is printed for the series.
 * 
 * After each n is completed, curr returns to 0 and the next query can begin.
 */

public class hackerrank_loops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        
        int init;
        int curr=0;
        
        for(int i=0;i<q;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            init = (int) (a+( Math.pow(2, 0)*b));
            curr += init;

            System.out.print(init+" ");

            for (int j=1; j<n; j++){
                curr += (int) (Math.pow(2,j))*b;
                System.out.print(curr+" ");
            }
            System.out.println();
            curr = 0;

        }
        in.close();
    }
}
