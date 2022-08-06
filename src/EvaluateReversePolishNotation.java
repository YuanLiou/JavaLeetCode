import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        // Expected: 22
        var sample01 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        var result = evalRPN(sample01);
        System.out.println("Result is " + result);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left + right);
                }
                case "-" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left - right);
                }
                case "*" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left * right);
                }
                case "/" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left / right);
                }
                default -> {
                    // Push the number into the stack
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }
}
