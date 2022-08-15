import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class ImplementQueueUsingStacks2 {

    public static void main(String[] args) {
        var myQueue = new ImplementQueueUsingStacks2();
        myQueue.push(1);
        var result01= myQueue.pop();
        var result02 = myQueue.empty();

        System.out.println("result 01 " + result01);
        System.out.println("result 02 " + result02);
    }

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> reversed = new Stack<>(); // Just like the Queue's sequence
    private int currentHead = 0;

    public ImplementQueueUsingStacks2() {
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            currentHead = x;
        }
        stack.push(x);
    }

    public int pop() {
        if (empty()) {
            return 0;
        }

        if (!reversed.isEmpty()) {
            return reversed.pop();
        }

        while (!stack.isEmpty()) {
            reversed.push(stack.pop());
        }
        return reversed.pop();
    }

    public int peek() {
        if (empty()) {
            return 0;
        }

        if (!reversed.isEmpty()) {
            return reversed.peek();
        }
        return currentHead;
    }

    public boolean empty() {
        return stack.isEmpty() && reversed.isEmpty();
    }
}
