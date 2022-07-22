public class BinarySearch {

    public static void main(String[] args) {
        var sample01 = new int[] {7, 11, 25, 38, 39, 54, 61, 86};
        var target = 25;

        var resultIndex = binarySearchIndex(sample01, target);
        System.out.println("Target index is " + resultIndex);
    }

    public static int binarySearchIndex(int[] inputs, int targets) {
        if (inputs == null || inputs.length == 0) {
            return -1;
        }

        int leftBound = 0;
        int rightBound = inputs.length - 1;

        while (leftBound <= rightBound) {
            int middleIndex = leftBound + (rightBound - leftBound) / 2;
            int currentNumber = inputs[middleIndex];
            if (currentNumber == targets) {
                return middleIndex;
            } else if (currentNumber > targets) {
                // It is too big, shrink the right bounds
                rightBound = middleIndex - 1;
            } else {
                // currentNumber < targets
                // It is too small, expand the left bounds
                leftBound = middleIndex + 1;
            }
        }

        return -1;
    }
}
