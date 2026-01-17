package cp

import kotlin.math.abs

//https://leetcode.com/problems/rectangle-area/description/
class Solution_223 {
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {

        val totArea: Int = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1)

        var interArea = 0
        if (ax2 > bx1 && bx2 > ax1 && ay2 > by1 && by2 > ay1) {
            val interB = Pair(maxOf(ax1, bx1), maxOf(ay1, by1))
            val interT = Pair(minOf(ax2, bx2), minOf(ay2, by2))

            interArea = abs(interB.first-interT.first)*abs(interB.second-interT.second)
        }

        return totArea-interArea
    }
}
