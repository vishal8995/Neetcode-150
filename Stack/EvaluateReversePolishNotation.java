package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> evalStack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+"))
                evalStack.push(evalStack.pop() + evalStack.pop());
            else if (s.equals("-")) {
                int op2 = evalStack.pop();
                int op1 = evalStack.pop();
                evalStack.push(op1 - op2);
            } else if (s.equals("*"))
                evalStack.push(evalStack.pop() * evalStack.pop());
            else if (s.equals("/")) {
                int op2 = evalStack.pop();
                int op1 = evalStack.pop();
                evalStack.push(op1 / op2);
            } else
                evalStack.push(Integer.parseInt(s));
        }
        return evalStack.pop();
    }

    public static void main(String[] args) {

        System.out.println(evalRPN(new String[] { "1", "2", "+", "3", "*", "4", "-" }));
        System.out
                .println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
    }
}
