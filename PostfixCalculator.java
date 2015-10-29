import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;


public class PostfixCalculator {

    public static void main(String[]args){

        System.out.println(compute("5 3 +"));
        System.out.println(compute("12 10 +"));
    }



    public static String compute(String s) {

        List<String> numberList = new ArrayList<String>();

        if (!s.isEmpty()) {
            StringTokenizer tokenizer = new StringTokenizer(s);
            while (tokenizer.hasMoreTokens()) {
                numberList.add(tokenizer.nextToken());
            }
        } else {
            return "Sorry, that is an error.";
        }


        // Use this for calculating

        Stack<String> calculationStack = new Stack<String>();

        //Iterate over the array list

        Iterator<String> iterator = numberList.iterator();

        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (temp.matches("[0-9]*")) {

                //If the current item is a number, push it to the stack
                calculationStack.push(temp);
            } else if (temp.matches("[+-/*]")) {


                //If the current item is an operator, pop off the last two elements of the stack
                // and calculate them using the operator we are looking at. Then, push the result onto the stack.

                if (temp.equals("+")) {
                    int a = Integer.parseInt(calculationStack.pop());
                    int b = Integer.parseInt(calculationStack.pop());
                    int result = a + b;
                    calculationStack.push(" " + result);
                } else if (temp.equals("-")) {
                    int a = Integer.parseInt(calculationStack.pop());
                    int b = Integer.parseInt(calculationStack.pop());
                    int result = a - b;
                    calculationStack.push(" " + result);
                } else if (temp.equals("/")) {
                    int a = Integer.parseInt(calculationStack.pop());
                    int b = Integer.parseInt(calculationStack.pop());
                    int result = a / b;
                    calculationStack.push(" " + result);
                } else if (temp.equals("*")) {
                    int a = Integer.parseInt(calculationStack.pop());
                    int b = Integer.parseInt(calculationStack.pop());
                    int result = a * b;
                    calculationStack.push(" " + result);
                }
            } else {
                return "Sorry, that is an error.";
            }
        }

        return calculationStack.pop();
    }
}




