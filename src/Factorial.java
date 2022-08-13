public class Factorial {
    public static void main(String[] args) {
        int result = factorial(4);
        System.out.println("Result is " + result);
    }

    private static int factorial(int n) {
        // base case
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }
}
