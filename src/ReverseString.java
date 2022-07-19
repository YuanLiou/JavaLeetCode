import utils.ArrayUtils;

public class ReverseString {
    public static void main(String[] args) {
        var sample01 = new char[]{'h', 'e', 'l', 'l', 'o'};
        var sample02 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

        reverseString(sample02);
        ArrayUtils.printCharArray(sample02);
    }

    public static void reverseString(char[] s) {
        // base case
        if (s == null || s.length == 0) {
            return;
        }

        // two-pointer
        int leftBound = 0;
        int rightBound = s.length - 1;
        while (leftBound < rightBound) {

            swap(s,leftBound,rightBound);

            leftBound++;
            rightBound--;
        }
    }

    // swap function
    private static void swap(char[] source, int indexA, int indexB) {
        char ogCharA = source[indexA];
        source[indexA] = source[indexB];
        source[indexB] = ogCharA;
    }
}
