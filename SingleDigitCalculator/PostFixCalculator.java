package SingleDigitCalculator; // Removeable package for anyone else to test.

import java.util.Stack; // Will use this in order to run program.
import java.util.Scanner; // Use of scanner for driver.

public class PostFixCalculator extends SelfPostFix {
	
	/*//// //// //// ////
	
	The method runs a loop in order to find characters. If these characters are digits,
	they are converted to integers to be pushed into the stack.
	
	This requires at least 2 operands or variables to be available in the stack to work.
	If not, will throw an exception.
	
	When the loop finds an operator, it pushes the top two values from the stack and
	returns their values to operand1 and operand2. Since the character is not a digit,
	the else statement sees what operation to perform evaluation 
	(Ex: operand1+operand2 if chr =='+') and pushes that result to the stack.
	
	If there are number(s) left over in the stack and the next character is still
	another operator, it will perform again. This time, operand2 will be the result 
	from before and the operand1 is the next operand to be evaluated.
	
	This continues until all operators are evaluated and the loop is done looking at characters.
	Result variable is equal to the next pop() as that pop() is the final result of the evaluation
	and is returned.

	Note: The loop will only find characters. So it is not possible to do numebers than 0 to 9.
	Will have to redo this package for proper calculator.
	
    */ //// //// //// ////
	
	public static int calculation(String str) {
        Stack<Integer> stack=new Stack<>(); 
        int result = 0;
          
        for(int i=0;i<str.length();i++) { 
            char chr=str.charAt(i); // Stores the charAt(position) to a variable.
              
            if(Character.isDigit(chr)) {
            	stack.push(Character.getNumericValue(chr)); // Character.getNumbericValue(char) turns said char into an integer.
            }
            
            else { // Can only be an operator
                int operand2 = stack.pop(); // Initialized 2nd variable and left over variables in stack.
                int operand1 = stack.pop(); // Initialized 1st variable and pushed result.
                 
                if(chr=='+') {
                	stack.push(operand1+operand2);
                }
                else if(chr=='-') {
                	stack.push(operand1-operand2);
                }
                else if(chr=='*') {
                	stack.push(operand1*operand2);
                }
                else if(chr=='/') {
                	stack.push(operand1/operand2);
                }
            } 
        } 
        
        result = stack.pop();
        return result;
	}

	public static int do_calculation(String do_calc){
		String postGet = postFixGet(do_calc);
		int post_result = calculation(postGet);
		return post_result;
	}
	
	// Main Driver
	public static void main(String[] args) 
	{ 
		/*
		System.out.println(calculation("9"));
		System.out.println(calculation("12+3+"));
		System.out.println(calculation("112++"));
		*/

		//System.out.println( do_calculation("1+2+9") );
		//System.out.println( calculation("1122+") );
		
		
		Scanner sc = new Scanner(System.in);
		int result;
		System.out.println("When typing out equation, integers must be from 0 to 9.");
		System.out.println("Please type a equation: ");
		String eq_input = sc.nextLine();
		result = do_calculation(eq_input);
		System.out.println( "Your result is: "+result );
		
	}
	
}



