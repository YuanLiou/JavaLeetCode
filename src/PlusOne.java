public class PlusOne {

    public static void main(String[] args) {
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }

        var digitSize = digits.length;
        // if the final digit is not 9
        if (digits[digitSize - 1] != 9) {
            digits[digitSize - 1] += 1;
            return digits;
        }

        // find the position is start NOT 9
        int index = digitSize - 1;
        while (index >= 0 && digits[index] == 9) {
            index--;
        }

        // they're all 9, add a new size with all 0
        if (index < 0) {
            int[] result = new int[digitSize + 1];
            result[0] = 1;
            return result;
        }

        digits[index] += 1;
        index++;
        while (index < digitSize) {
            digits[index] = 0;
            index++;
        }
        return digits;
    }

}
