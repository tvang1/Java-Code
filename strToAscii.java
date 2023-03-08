import java.util.*;
public class strToAscii { //Beginning of Class
	
	/*
	 * This program was made for fun. I wanted to make a text to ASCII converter.
	 * Learning ASCII to text would help in proficiency.
	 */
	
	// Methods
	
	/* Method 1
	 * This will turn a String or sentence into ASCII.
	*/
	public String toAscii(String a) {
		String b = "";
		char holder;
		
		for (int i=0; i<a.length(); i++) {
			holder = a.charAt(i);
			b+= (int)holder+" ";
		}
		
		return b;
	} // End of Method 1
	
	/* Method 2
	 * This will turn an int to a String.
	 * To turn a whole sentence to a Strings, 
	 * there must be user input or a loop of some kind.
	*/ 
	public String asciiToString(int a) {
		String b="";
		b+= Character.toString(a);
		return b;
	} // End of Method 2
	
	/* Method 3
	 * A test for recursion for practice
	*/
	
	/*
	
	int repeat=0;
	public String testRec (int a) {
		System.out.println("Did a thing.");
		while ( a>0 ) {
			if(a>0) {
				a--;
				repeat++;
				this.testRec(a);
			}
		}
		return "It was repeated "+repeat+" times.";
	} // End of Method 3
	
	*/
	
	// End of Class
	
	// Driver //
	public static void main(String[] agrs) {
		
		@SuppressWarnings("resource") // Warning that scanner isn't closed. 
		Scanner sc =  new Scanner(System.in);
		int choice=0; // used for prompt
		String trans; // used to parse toAscii()
		int inpt; // used to parse asciiToString()
		strToAscii abc = new strToAscii(); // constructor and calling class
	
		// Testing Methods
		//System.out.println( abc.testRec(10)+"\n" );
		//System.out.println( abc.toAscii("Ok Boomer.") );
		//System.out.print( abc.asciiToString(79) );
		//System.out.print( abc.asciiToString(107)+"\n\n" ); // requires loop?
		
		
		while ( choice!=1 && choice!=2 ) { // Simple Prompt
			
			try {
				System.out.println("Turn text to ASCII type \"1\" ");
				System.out.println("Turn ASCII to text type \"2\" ");
				choice = sc.nextInt();
				}
			
			catch (Exception e) {
				System.out.println("Invalid choice. Ending program.");
				break;
			}
			
		}
		
		if ( choice == 1 ) {
			
			System.out.println("Please type your text to ASCII: ");
			trans = sc.next();
			
			System.out.print( abc.toAscii( trans ) );
			
			while ( sc.hasNext() ) { /*
			 						  *Requires to check to see if there is something in the next 
			 						  *line as .next() only has an input per line.
			 						  */
				System.out.print( abc.toAscii( sc.nextLine() ) );
			}
			System.exit(0);
			
		}
		
		if ( choice == 2 ) {
			
			System.out.println("Please type ASCII to text: ");
			inpt = sc.nextInt();
			
			System.out.print( abc.asciiToString( inpt ) );
			
			while ( sc.hasNextInt() ) { /*
										*This one also does a check. Behaves differently.
										*Since there is a hasNextInt, inpt needs to be defined as the
										*next one. Since there are multiple lines, when defining
										*inpt as nextInt() will go to the next available int 
										*in the input.
										*/
				inpt = sc.nextInt();
				System.out.print( abc.asciiToString( inpt ) );
			}
			System.exit(0);
		}
		
	} // End of Driver

} // End of File
