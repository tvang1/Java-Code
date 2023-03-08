import java.util.Scanner;

/*
 * In each line of output there should be two columns:
 * The first column contains the String and is left justified using exactly 15 characters.
 * The second column contains the integer, expressed in exactly  digits; if the original input has less than 3 digits,
 * you must pad your output's leading digits with zeroes.
 */

public class hackerrank_15Chars {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                int num_space = 15-s1.length();
                
                System.out.print(s1);
                for (int j=0; j<num_space; j++){
                  System.out.print(" ");
                }
                num_space = 0;
                
                if (x<10){
                    System.out.print("00");
                }
                else if (x<100){
                    System.out.print("0");
                }
                System.out.print(x);
                System.out.println();
                //Complete this line
            }
            System.out.println("================================");

            sc.close();

    }
}