import java.util.Stack;

public class MinStack {

    private int currentMinValue = Integer.MAX_VALUE;
    private Stack<MinNode> stack;

    public MinStack() {
        stack = new Stack<MinNode>();
    }

    // pushes the element val onto the stack.
    public void push(int val) {
        MinNode node = new MinNode(val, currentMinValue);
        updateMinValue(val);
        stack.push(node);
    }

    // removes the element on the top of the stack.
    public void pop() {
        MinNode currentNode = stack.pop();
        if (currentNode.value == currentMinValue) {
            currentMinValue = currentNode.previousMin;
        }
    }

    // gets the top element of the stack.
    public int top() {
        return stack.peek().value;
    }

    // retrieves the minimum element in the stack.
    public int getMin() {
        return currentMinValue;
    }

    private void updateMinValue(int minValue) {
        currentMinValue = Math.min(currentMinValue, minValue);
    }

    public record MinNode(int value, int previousMin){};
}

