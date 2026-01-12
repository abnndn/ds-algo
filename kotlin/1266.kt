package cp

// https://leetcode.com/problems/minimum-time-visiting-all-points/?envType=daily-question&envId=2026-01-12
class Solution_1266 {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var ans = 0

        var diff1 = 0
        var diff2 = 0
        for (i in 1 until points.size) {
            diff1 = abs(points[i][0]-points[i-1][0])
            diff2 = abs(points[i][1]-points[i-1][1])

            ans += maxOf(diff1, diff2)
        }

        return ans
    }
}
