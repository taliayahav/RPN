package rpn;

import java.util.Scanner;

/**
 *
 * @author taliayahav
 */
public class RPN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true)
        {
            RPNCalculator numbers = new RPNCalculator();
            System.out.println("Please enter your numbers and operands ");
            System.out.println("If you would like to end the program, press y");
            Scanner keyboard = new Scanner(System.in);
            String stInput = keyboard.nextLine();
            if (stInput.equalsIgnoreCase("y"))
            {
                System.out.println("Your program is finished.");
                break;
            }
            else
                System.out.println(numbers.evaluate(stInput));
        }
    }

}
