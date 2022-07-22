package counterpart

import kotlin.math.max

fun main() {
    val testDrive = KLargestNumberAtLeastTwiceOthers()
    // expect: 3
    val result01 = testDrive.dominantIndex(intArrayOf(0, 0, 0, 1))
    // expect: -1
    val result02 = testDrive.dominantIndex(intArrayOf(1, 2, 3, 4))
    println("Result is $result01")
}

class KLargestNumberAtLeastTwiceOthers {

    fun dominantIndex(nums: IntArray): Int {
        var maxIndex = -1
        var maxValue = Integer.MIN_VALUE
        for ((index, num) in nums.withIndex()) {
            if (num > maxValue) {
                maxValue = num
                maxIndex = index
            }
        }

        for ((index, num) in nums.withIndex()) {
            if (index == maxIndex) {
                continue
            }

            if (maxValue < (num * 2)) {
                return -1
            }
        }
            
        return maxIndex;
    }
}