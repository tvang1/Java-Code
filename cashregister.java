import java.util.Scanner;

/* 
 * This is a cash register program that will sort an input of cash. It should exchange out according
 * to the US dollar ($100s, $50s, etc... ) and cents (.50c, .25c, etc...).
 * 
 * Uses a method where the it takes a double parameter:
 * 
 *      sort_change(double change)
 * 
 * In this method, it will take the 'change' variable and have it equal the 'curr_change' variable.
 * From there, there are number of 'if statements' dedicated to division and modding. Division for the
 * whole ammounts and modding for the remainders/curr_change.
 * 
 * It will go to the next ammount or permissible 'if statement'. Once at the pennies or cents, it had
 * to be rounded up in order to get correct cents.
 * 
 * This program goes through 2 'while loops' to ensure exceptions and correct input of disired use.
 * 
*/

public class cashregister {

    public static String sort_change(double change){

        double hundr=0, fifty=0, twenty=0, ten=0, five=0, one=0, fifty_cent=0, quart=0, dime=0, nick=0, cent = 0;
        double curr_change =  change;

        if (curr_change >=100){
            hundr = curr_change/100;
            curr_change = curr_change%100;
        }

        if (curr_change >= 50){
            fifty = curr_change/50;
            curr_change = curr_change%50;
        }

        if (curr_change >= 20){
            twenty = curr_change/20;
            curr_change = curr_change%20;
        }

        if (curr_change >= 10){
            ten = curr_change/10;
            curr_change = curr_change%10;
        }

        if (curr_change >= 5){
            five = curr_change/5;
            curr_change = curr_change%5;
        }

        if (curr_change >= 1){
            one = curr_change/1;
            curr_change = curr_change%1;
        }

        if (curr_change<1){
            curr_change = curr_change*100;
        }

        if (curr_change>=50){
            fifty_cent = curr_change/50;
            curr_change = curr_change%50;
        }

        if (curr_change>=25){
            quart = curr_change/25;
            curr_change = curr_change%25;
        }

        if (curr_change>=10){
            dime = curr_change/10;
            curr_change = curr_change%10;
        }

        if (curr_change>=5){
            nick = curr_change/5;
            curr_change = curr_change%5;
        }

        curr_change = Math.round(curr_change);
        if (curr_change>=1){
            cent = curr_change/1;
        }

        String result = "Hundreds: "+(int)hundr+", Fifty: "+(int)fifty+", Twenties: "+(int)twenty+", Tens: "+(int)ten+", Fives: "+(int)five+", Ones: "+(int)one+", Fift-Cents: "+(int)fifty_cent+", Quarters: "+(int)quart+", Dimes: "+(int)dime+", Nickles: "+(int)nick+", Pennies: "+(int)cent;

        return result;
    }


    // Driver Class
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cont1 = 1;
        int cont2 = 1;
        String prompt = "";

        while (cont1 == 1) {
            cont2 =1;
            System.out.println("Keep money format to #####.## (Two Decimal Places).");
            System.out.println("Enter Money needed to change:");
            try {
                double input = sc.nextDouble();
                System.out.println( sort_change(input) );
            }
            catch (Exception e) {
                System.out.println("Entry entered was not in correct format.");
            }

            System.out.println("Continue? \n Type 'Yes' or 'No'. ");
            
            try {
                while (cont2==1){

                    prompt = sc.nextLine();

                    if ( prompt.equalsIgnoreCase("yes") ){
                        cont1 = 1;
                        cont2 = 0;
                    }
                    else if ( prompt.equalsIgnoreCase("no") ) {
                        cont1 = 0;
                        cont2 = 0;
                        sc.close();
                        System.exit(0);
                    }
                }
                
            }
            catch (Exception e) {
                System.out.println("An error occured. Will exit...");
                sc.close();
                System.exit(1);
            }
        }
    } 

}