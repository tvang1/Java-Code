import java.util.Scanner;
import java.util.Random;

/* This is a program that asks a user to generate 2 random generated lists of
 * various lengths and will compare list2 elements to list1 elements.
 * The final output displays how many "less thans or equal to"(s).
*/

class QA_howMnyLessThanEq {

    // Method //

    // variable declarations
    int m, n, curr;
    int list1[], list2[], solution_list[];

    // This is the method itself. Takes two integer parameters m and n.
    public void howMnyLessThanEq(int m, int n) {
        Random rand = new Random();

        this.m = m;
        this.n = n;

        // Precheck to see if 0 is placed. Can not have an empty list.
        // If it passes, then the length of the array list is created.
        if (m <=0){
            System.out.println("m is less than 0. Will exit.");
            System.exit(0);
        }
        else {
            list1 = new int[m];
        }

        if (n <=0){
            System.out.println("n is less than 0. Will exit.");
            System.exit(0);
        }
        else {
            list2 = new int[n]; 
        }

        // Randomly generates values into lists. If at one, then no for loop.
        System.out.print("list1 is: ");
        if (list1.length == 1){
            curr =  rand.nextInt(10);
            list1[0] = curr;
            System.out.print(list1[0]);
            System.out.println();
        }
        else {
            for (int i=0; i<m; i++){
                curr =  rand.nextInt(10);
                list1[i] = curr;
                System.out.print(list1[i]+" ");
            }
            System.out.println();
        }

        System.out.print("list2 is: ");
        if (list2.length == 1){
            curr =  rand.nextInt(10);
            list2[0] = curr;
            System.out.print(list2[0]+" ");
            System.out.println();
        }
        else {
            for (int i=0; i<n; i++){
                curr =  rand.nextInt(10);
                list2[i] = curr;
                System.out.print(list2[i]+" ");
            }
            System.out.println();
        }

        /* How to evaluate
         * Elements in the second array are compared to elements of the first list
         * in this order:
         * 
         * list2[0] <= list1[0]
         * list2[0] <= list1[1]
         * list2[0] <= list1[2] ....
         * Store number of correct solutions to solutions_array[0]
         * Make curr back to 0.
         *  
         * list2[1] <= list1[0]
         * list2[1] <= list1[1]
         * list2[1] <= list1[2] ....
         * Store number of correct solutions to solutions_array[1]
         * Make curr back to 0
         */

        curr = 0;
        solution_list = new int[list1.length];

        for (int i=0; i<solution_list.length; i++){
            for (int j=0; j<list2.length; j++){
                if (list2[j]<=list1[i]){
                    curr+=1;
                }
            }
            solution_list[i] = curr;
            curr = 0; // Need to become 0 so that next part of the array is correct number.
        }

        System.out.println("Solution to this is: ");
        for (int i=0; i<solution_list.length;i++){
            System.out.print(solution_list[i]+" ");
        }

    }

    // Driver
    public static void main(String[] args) {

        QA_howMnyLessThanEq num1 = new QA_howMnyLessThanEq();
        Scanner s = new Scanner(System.in);
        
        int m, n;

        System.out.println("Please determine size of list1: ");
        m = s.nextInt();
        System.out.println("Please determine size of list2: ");
        n = s.nextInt();

        num1.howMnyLessThanEq(m,n);
        s.close();

    }
}