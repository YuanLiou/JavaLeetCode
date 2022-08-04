package duplica;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStack {
    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min01 = minStack.getMin();
        minStack.pop();
        int top01 = minStack.top();
        int min02 = minStack.getMin();

        System.out.println("min01: " + min01);
        System.out.println("top01: " + top01);
        System.out.println("min02: " + min02);
    }

    private record Pair(int value, int previousMin){};

    private int currentMinValue;
    private Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
        currentMinValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            currentMinValue = val;
        }

        stack.push(new Pair(val, currentMinValue));
        currentMinValue = Math.min(currentMinValue, val);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        var poppedOne = stack.pop();
        if (poppedOne.value == currentMinValue) {
            // 就算前面有相同的數字，他如果是最小的，那他應該也會是 previousMin
            currentMinValue = poppedOne.previousMin();
        }
    }

    public int top() {
        return stack.peek().value();
    }

    public int getMin() {
        return currentMinValue;
    }
}
