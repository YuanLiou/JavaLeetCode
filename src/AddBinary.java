public class AddBinary {
    public static void main(String[] args) {
        String a1 = "11";
        String b1 = "1";

        String a2 = "1010";
        String b2 = "1011";

        String a3 ="1111";
        String b3 = "1111";

        var result = addBinary(a3, b3);
        System.out.println("This is the result " + result);
    }


    public static String addBinary(String a, String b) {
        // base case
        if (a == null && b == null) {
            return "";
        }

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        int rightBoundaryOfA = a.length() - 1;
        int rightBoundaryOfB = b.length() - 1;

        int carry = 0;

        int maxLength = Math.max(a.length(), b.length());
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < maxLength; i++) {
            int currentAIndex = rightBoundaryOfA - i;
            int currentA;
            if (currentAIndex >= 0) {
                currentA = Character.getNumericValue(a.charAt(currentAIndex));
            } else {
                currentA = 0;
            }

            int currentBIndex = rightBoundaryOfB - i;
            int currentB;
            if (currentBIndex >= 0) {
                currentB = Character.getNumericValue(b.charAt(currentBIndex));
            } else {
                currentB = 0;
            }

            int sum = currentA + currentB + carry;

            carry = sum / 2;
            if (sum > 1) {
                stringBuilder.insert(0, sum - 2);
            } else {
                stringBuilder.insert(0, sum);
            }
        }

        if (carry != 0) {
            stringBuilder.insert(0, carry);
        }

        return stringBuilder.toString();
    }

    public static String addBinaryFailed(String a, String b) {
        // base case
        if (a == null && b == null) {
            return "";
        }

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        int numA = Integer.parseInt(a); // Number Format Exception
        int numB = Integer.parseInt(b); // Number Format Exception
        int carry = 0;

        int maxLength = Math.max(a.length(), b.length());
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < maxLength; i++) {
            int currentA = numA % 10;
            int currentB = numB % 10;
            int sum = currentA + currentB + carry;

            carry = sum / 2;
            numA /= 10;
            numB /= 10;

            if (sum > 1) {
                stringBuilder.insert(0, sum - 2);
            } else {
                stringBuilder.insert(0, sum);
            }
        }

        if (carry != 0) {
            stringBuilder.insert(0, carry);
        }

        return stringBuilder.toString();
    }
}
