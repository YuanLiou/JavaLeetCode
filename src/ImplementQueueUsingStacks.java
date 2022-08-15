import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        var myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        var result01 = myQueue.peek();
        var result02= myQueue.pop();
        var result03 = myQueue.empty();

        System.out.println("result 01 " + result01);
        System.out.println("result 02 " + result02);
        System.out.println("result 03 " + result03);
    }

    private Stack<Integer> stack = new Stack<>();

    public ImplementQueueUsingStacks() {
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (empty()) {
            return 0;
        }

        Stack<Integer> anotherStack = new Stack<>();
        while (stack.size() > 1) {
            anotherStack.push(stack.pop());
        }

        int result = stack.pop();
        while (!anotherStack.empty()) {
            stack.push(anotherStack.pop());
        }
        return result;
    }

    public int peek() {
        if (empty()) {
            return 0;
        }

        Stack<Integer> anotherStack = new Stack<>();
        while (!stack.isEmpty()) {
            anotherStack.push(stack.pop());
        }

        int result = anotherStack.peek();
        while (!anotherStack.empty()) {
            stack.push(anotherStack.pop());
        }
        return result;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
