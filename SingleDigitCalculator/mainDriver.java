package SingleDigitCalculator;

import java.util.Scanner;

public class mainDriver extends PostFixCalculator{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
		int result;
		System.out.println("When typing out equation, integers must be from 0 to 9.");
		System.out.println("Please type a equation: ");
		String eq_input = sc.nextLine();
		result = do_calculation(eq_input);
		System.out.println( "Your result is: "+result );
        
    }
    
}
