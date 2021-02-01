package rpn;

import java.util.*;
import java.util.Stack;

/**
 * The RPN will evaluate the given operands the operators provided afterwards
 * and perform that equation
 *
 * @author taliayahav
 */
public class RPNCalculator {

    double a;
    double b;
    private Stack<Double> stack = new Stack<>();

    /**
     * private method checks if stack is empty, if not, pops the two numbers
     * from the stack (to perform the operations)
     */
    private boolean stackPopping() {
        boolean retVal = false;
        if (!stack.isEmpty()) {
            a = stack.pop();
            if (!stack.isEmpty()) {
                b = stack.pop();
                retVal = true;
            }

        }
        return retVal;
    }

    public String evaluate(String stInput) {
        String retVal = "Syntax Error"; //for the return
        String[] token = stInput.split(" ");
        for (int ix = 0; ix < token.length; ++ix) {
            String parse = token[ix];
            try {
                Double num = Double.parseDouble(parse);
                stack.push(num);
            } catch (NumberFormatException e) {
                if (stackPopping() == true) {
                    if (parse.equals("+")) {
                        stack.push(a + b);
                    } else if (parse.equals("-")) {
                        stack.push(b - a);
                    } else if (parse.equals("*")) {
                        stack.push(a * b);
                    } else if (parse.equals("/")) {
                        stack.push(b / a);
                    }
//                } else {
//                    return retVal;
//                }
                    retVal = stack.pop() + "";
                } else {
                    retVal = "too many operands";
                }
            }
        }

        return retVal;
    }
}
