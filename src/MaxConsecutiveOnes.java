public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        // expected: 3
        var sample01 = new int[]{1, 1, 0, 1, 1, 1};
        // expected: 2
        var sample02 = new int[]{1, 0, 1, 1, 0, 1};
        // expected: 0
        var sample03 = new int[]{0};
        // expected: 1
        var sample04 = new int[]{1, 0};
        var result = findMaxConsecutiveOnes(sample01);
        System.out.println("Result is " + result);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            return 0;
        }

        // Pick number one by one, counts the max counts ONE BY ONE
        int counts = 0;
        int maxCounts = 0;

        for (int number: nums) {
            if (number == 1) {
                counts++;
                maxCounts = Math.max(maxCounts, counts);
            } else {
                counts = 0;
            }
        }
        return maxCounts;
    }
}
