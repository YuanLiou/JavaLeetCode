import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import utils.ArrayUtils;

public class StrobogrammaticNumber2 {
    public static void main(String[] args) {
        List<String> result = findStrobogrammatic(4);
        ArrayUtils.printStringList(result);
    }
    public static List<String> findStrobogrammatic(int n) {
        return generateStrobogrammaticNumbers(n, n);
    }

    // (base case) Strobogrammatic number in n = 0: ""
    // (base case) Strobogrammatic number in n = 1: 0, 1, 8
    // Strobogrammatic number in n = 2: 00 (invalid), 11, 88, 69, 96
    // Strobogrammatic number in n = 3:
    //  '1' + Strobogrammatic number in n = 1 + '1'
    //  '8' + Strobogrammatic number in n = 1 + '8'
    //  '6' + Strobogrammatic number in n = 1 + '9'
    //  '9' + Strobogrammatic number in n = 1 + '6'
    // Strobogrammatic number in n = 4:
    //  '1' + Strobogrammatic number in n = 2 + '1'
    //  '8' + Strobogrammatic number in n = 2 + '8'
    //  '6' + Strobogrammatic number in n = 2 + '9'
    //  '9' + Strobogrammatic number in n = 2 + '6'
    // Strobogrammatic number in n = n:
    //  '1' + Strobogrammatic number in n = n - 2 + '1'
    //  '8' + Strobogrammatic number in n = n - 2 + '8'
    //  '6' + Strobogrammatic number in n = n - 2 + '9'
    //  '9' + Strobogrammatic number in n = n - 2 + '6'
    private static List<String> generateStrobogrammaticNumbers(int n, int finalLength) {
        char[][] pairs = new char[][] {
            { '0', '0' },
            { '1', '1' },
            { '8', '8' },
            { '6', '9' },
            { '9', '6' }
        };

        // Return with base case: Strobogrammatic number size == 0 OR 1
        if (n == 0) {
            return List.of("");
        }

        if (n == 1) {
            return List.of("0", "1", "8");
        }

        // Get the center Strobogrammatic number based on n - 2 formula above
        List<String> centerStroboNumbers = generateStrobogrammaticNumbers(n - 2, finalLength);
        List<String> result = new ArrayList<>();
        // Concat the each Strings
        for (String stroboNumbers : centerStroboNumbers) {
            for (char[] pair : pairs) {
                // We only want the '0' in the centerStroboNumbers,
                // so we put `n != finalLength here to allow first '0' put into result
                // and the result number start with '0' is invalid.
                if (pair[0] != '0' || n != finalLength) {
                    result.add(pair[0] + stroboNumbers + pair[1]);
                }
            }
        }

        return result;
    }
}
