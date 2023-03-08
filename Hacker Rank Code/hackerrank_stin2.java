import java.util.Scanner;

public class hackerrank_stin2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String j = scan.nextLine(); // Needs to be places to help with the queue so that the next String is readable. Currently, will be empty.
        String s = scan.nextLine();
        scan.close();

        // Write your code here.
        
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        
    }
}