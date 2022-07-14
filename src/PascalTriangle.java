import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ArrayUtils;

public class PascalTriangle {
    public static void main(String[] args) {
        var numRows = 5;
        var numRows02 = 1;
        var result = generate(numRows02);
        for (List<Integer> innerList : result) {
            System.out.println("");
            ArrayUtils.printIntList(innerList);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        // base case
        if (numRows == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultArray = new ArrayList<>();
        int newArrayRow = numRows + 1;
        for (int i = 1; i < newArrayRow; i++) {
            List<Integer> generatedArray = new ArrayList<>();
            if (i != 1) {
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        generatedArray.add(1);
                    } else {
                        List<Integer> previousList = resultArray.get(i - 2);
                        int result = previousList.get(j - 1) + previousList.get(j);
                        generatedArray.add(result);
                    }
                }
            } else {
                generatedArray.add(1);
            }
            resultArray.add(generatedArray);
        }
        return resultArray;
    }
}
