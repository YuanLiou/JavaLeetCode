public class MultiplyStrings {
    public static void main(String[] args) {
        String sample01a = "123";
        String sample01b = "456";

        String sample02a = "9";
        String sample02b = "9";

        String sample03a = "9";
        String sample03b = "99";

        String result = multiply(sample01a, sample01b);
        System.out.println("Result is " + result);
    }

    public static String multiply(String num1, String num2) {
        // base case
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num1.equals("1")) {
            return num2;
        }

        if (num2.equals("1")) {
            return num1;
        }

        // 直式乘法
        int mSize = num1.length();
        int nSize = num2.length();

        int[] resultIntArray = new int[mSize + nSize];

        for (int j = nSize - 1; j >= 0; j--) {
            for (int i = mSize - 1; i >= 0; i--) {
                // Doing multiply
                int multiplyResult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // 加上，上一次算出來的左邊那個數字
                multiplyResult += resultIntArray[i + j + 1];

                // 處理這次計算的結果
                resultIntArray[i + j + 1] = multiplyResult % 10; // 右邊數字
                // carry，用 += 是因為這個欄位是上一個 operation 的 i + j + 1 留下來的數字。
                // 上一個右邊數字(現在的 Operation 變成左邊數字） += 這次的左邊數字
                resultIntArray[i + j] += multiplyResult / 10; // 左邊數字
            }
        }

        // 轉換成 String
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : resultIntArray) {
            // 去除首字母是 0 的情形
            if (stringBuilder.length() == 0 && number == 0) {
                continue;
            }
            System.out.println("number is " + number);
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
