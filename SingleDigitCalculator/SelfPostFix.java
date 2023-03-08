package SingleDigitCalculator;

import java.util.Stack;

public class SelfPostFix {
	static String inFix;
	static Stack<Character> s;
	
	public static String postFixGet(String inStr) {
		String postFix="";
		inFix = inStr;
		boolean firstItem =false;
		s= new Stack<Character>();
		
		for (int i =0; i<inFix.length();i++) {
			char curChar = inFix.charAt(i);
			if (!isOperator(curChar)) {
				postFix+=Character.toString(curChar);
				
				if(i==(inFix.length()-1)) { // put all operators to end of string
					while(!s.empty()) {
						postFix+=s.pop();
					}
				}	
			}
			
			else if(firstItem) {
				if( plus_Or_Min(curChar) && plus_Or_Min( (char) s.peek() ) ) {
					postFix += s.pop();
					s.push(curChar);
					
					if(i==(inFix.length()-1)) { 
						while(!s.empty()) {
							postFix+=s.pop();
						}
					}
				
				}
				else if( mult_Or_Div(curChar) && mult_Or_Div( (char) s.peek() ) ) {
					postFix += s.pop();
					s.push(curChar);
					
					if(i==(inFix.length()-1)) { 
						while(!s.empty()) {
							postFix+=s.pop();
						}
					}
				}
				else if( plus_Or_Min(curChar) && mult_Or_Div( (char) s.peek() ) ) {
					postFix += s.pop();
					s.push(curChar);
					
					if(i==(inFix.length()-1)) { 
						while(!s.empty()) {
							postFix+=s.pop();
						}
					}
				}
				else if( mult_Or_Div(curChar) && plus_Or_Min( (char) s.peek() ) ) {
					s.push(curChar);
					
					if(i==(inFix.length()-1)) { 
						while(!s.empty()) {
							postFix+=s.pop();
						}
					}
				}
				else {
					postFix+=Character.toString(curChar);
					if(i==(inFix.length()-1)) { 
						while(!s.empty()) {
							postFix+=s.pop();
						}
					}
				}
			}
			else {
				s.push(curChar);
				firstItem =true;
			}
			
		}
	return postFix;
	}
	
	public static boolean isOperator(char op) {
		switch(op) {
		case '+':
			return true;
		case '-':
			return true;
		case '*':
			return true;
		case '/':
			return true;
		default:
			return false;
		}
	}
	
	public static boolean plus_Or_Min(char op) {
		switch(op) {
		case '+':
			return true;
		case '-':
			return true;
		default:
			return false;
		}
	}
	
	public static boolean mult_Or_Div(char op) {
		switch(op) {
		case '*':
			return true;
		case '/':
			return true;
		default:
			return false;
		}
	}
	
	// Basic Driver to test the the stack.
	public static void main(String[] args) 
	{ 
		System.out.println(postFixGet("11+22"));

	}
	
}


