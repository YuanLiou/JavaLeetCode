package counterpart

fun main() {
    val sample01 = intArrayOf(1, 7, 3, 6, 5, 6)
    val sample02 = intArrayOf(1, 2, 3)
    val sample03 = intArrayOf(2, 1, -1)
    val question = KFindPivotIndex()
    val result = question.pivotIndex(sample03)
    println("Pivot index is $result")
}

class KFindPivotIndex {

    fun pivotIndex(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1;
        }

        // get the sum
        val sum = nums.sum()

        // compare the number, if there has a piovt
        var currentLeftSum = 0
        for ((index, currentNumber) in nums.withIndex()) {
            val currentRightSum = sum - (currentLeftSum + currentNumber)
            if (currentLeftSum == currentRightSum) {
                return index
            }

            currentLeftSum += currentNumber
        }

        return -1;
    }
}