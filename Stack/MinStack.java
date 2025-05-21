package Stack;

import java.util.Stack;

// Two Stack Solution: O(n) space and O(1) time for all operations
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int top = stack.pop();
        if (top == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        System.out.println("Top: " + minStack.top()); // Should be 7
        System.out.println("Min: " + minStack.getMin()); // Should be 3
        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Should be 3
        System.out.println("Min: " + minStack.getMin()); // Should still be 3
        minStack.pop();
        System.out.println("Min: " + minStack.getMin()); // Should be 5
    }

}
