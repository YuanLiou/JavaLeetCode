public class Fibonacci {

    private static long[] fibonacciCaches; //<== Memoization

    public static void main(String[] args) {
        // index0 1 2 3 4 5 6 7  8  9
        // num: 0 1 1 2 3 5 8 13 21 34...

        int target = 50;
        fibonacciCaches = new long[target + 1]; // e.g. target set to 3, index is 4

        long result = fibonacci(target);
        System.out.println("result is " + result);
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // check previous cache
        if (fibonacciCaches[n] != 0) {
            return fibonacciCaches[n];
        }

        long fibonacciResult = fibonacci(n - 1) + fibonacci(n - 2);
        fibonacciCaches[n] = fibonacciResult; // save the cache

        return fibonacciResult;
    }
}
