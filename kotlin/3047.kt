package cp

// https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/?envType=daily-question&envId=2026-01-17
data class Entry(val pos: Int, val label: Char)

class Solution_3047 {
    fun largestSquareArea(bl: Array<IntArray>, tr: Array<IntArray>): Long {
        var len = 0
        for (i in 0 until bl.size) {
            for (j in i+1 until bl.size) {
                // print("Rec1: {BL: ${bl[i][0]}, ${bl[i][1]}}, {TR: ${tr[i][0]}, ${tr[i][1]}}\n")
                // print("Rec2: {BL: ${bl[j][0]}, ${bl[j][1]}}, {TR: ${tr[j][0]}, ${tr[j][1]}}\n")

                if (tr[i][0]<=bl[j][0] || tr[i][1]<=bl[j][1] || tr[j][0]<=bl[i][0] || tr[j][1]<=bl[i][1]) {
                    // print("skipped \n")
                    // Skipping all non overlapping rectangles
                    continue
                }
                var inter_b = Pair(maxOf(bl[i][0],bl[j][0]), maxOf(bl[i][1], bl[j][1]))
                var inter_t = Pair(minOf(tr[i][0], tr[j][0]), minOf(tr[i][1], tr[j][1]))

                // print("Intersection: {BL: ${inter_b.first}, ${inter_b.second}}, {TR: ${inter_t.first}, ${inter_t.second}}}\n")

                len = maxOf(len, minOf(abs(inter_b.first-inter_t.first), abs(inter_b.second-inter_t.second)))
            }
        }

        return len.toLong() * len.toLong()

    }
}
