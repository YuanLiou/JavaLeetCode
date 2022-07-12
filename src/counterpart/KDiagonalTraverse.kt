package counterpart

fun main() {
    val sample01 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    val sample02 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )

    val diagonalTraverse = KDiagonalTraverse()
    val result = diagonalTraverse.findDiagonalOrder(sample02)
    for (i in result) {
        print("$i, ")
    }
}

class KDiagonalTraverse {

    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        // base case
        if (mat.isEmpty()) {
            return intArrayOf()
        }

        // base case: if there is only one row
        if (mat.size == 1) {
            return mat[0]
        }

        val row = mat.size
        val column = mat[0].size
        val resultArray = Array<Int>(row * column) { 0 }

        var currentRow: Int = 0
        var currentColumn: Int = 0

        for (index in resultArray.indices) {
            resultArray[index] = mat[currentRow][currentColumn]
            if ((currentRow + currentColumn) % 2 == 0) {
                // Calculation toward Up
                if (currentColumn == column - 1) {
                    // Moving to bottom
                    currentRow++
                } else if (currentRow == 0) {
                    // Moving right
                    currentColumn++
                } else {
                    // otherwise, keep moving to top-right
                    currentRow--
                    currentColumn++
                }
            } else {
                // Calculation toward Down
                if (currentRow == row - 1) {
                    // Moving to right
                    currentColumn++
                } else if (currentColumn == 0) {
                    // Moving down
                    currentRow++
                } else {
                    // otherwise, keep moving to left-down
                    currentRow++
                    currentColumn--
                }
            }
        }
        return resultArray.toIntArray()
    }
}