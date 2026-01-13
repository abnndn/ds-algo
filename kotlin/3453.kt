package cp

//https://leetcode.com/problems/separate-squares-i/?envType=daily-question&envId=2026-01-13
class Solution_2453 {
    fun separateSquares(squares: Array<IntArray>): Double {
        val epsilon = 0.00001

        var total_area: Double = 0.0
        var max_int: Int = 0
        for (i in squares.indices) {
            total_area += (squares[i][2].toLong() * squares[i][2].toLong()).toDouble()

            squares[i][2] += squares[i][1]

            if (max_int < squares[i][2]) {
                max_int = squares[i][2]
            }

        }
        squares.sortWith(compareBy({it[2]}, {it[0]}))

        // print("[")
        // for (i in squares.indices) {
        //     print("[${squares[i][1]},${squares[i][2]}],")
        // }
        // print("]\n")
        // print("total_area: $total_area \n")

        var min: Double = 0.0
        var max = max_int.toDouble()
        var mid: Double

        while(abs(max-min) > epsilon) {
            mid = (min+max)/2
            // print("min: $min, max: $max, mid: $mid -- ")
            var curr_area: Double = 0.0
            for (i in squares.indices) {
                if (squares[i][2].toDouble() < mid) {
                    curr_area += (squares[i][2]-squares[i][1]).toDouble() * (squares[i][2]-squares[i][1]).toDouble()
                } else if (squares[i][1].toDouble() < mid) {
                    curr_area += (squares[i][2]-squares[i][1]).toDouble() * (mid-squares[i][1].toDouble())
                }
            }
            // print("curr_area: $curr_area \n")

            if (curr_area >= total_area/2) {
                max = mid
            } else {
                min = mid
            }
        }
        return max

    }
}
