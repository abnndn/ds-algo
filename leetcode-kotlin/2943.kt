package cp

// https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/description/?envType=daily-question&envId=2026-01-15
class Solution_2943 {
    fun maximizeSquareHoleArea(n: Int, m: Int, hor: IntArray, ver: IntArray): Int {
        hor.sort()
        ver.sort()

        var hc_max = 1
        var hc = 1
        for (i in 1 until hor.size) {
            if (hor[i] == hor[i-1]+1) {
                hc++
            } else {
                hc_max = maxOf(hc_max, hc)
                hc = 1
            }
        }
        hc_max = maxOf(hc_max, hc)

        var vc_max = 1
        var vc = 1
        for (i in 1 until ver.size) {
            if (ver[i] == ver[i-1]+1) {
                vc++
            } else {
                vc_max = maxOf(vc_max, vc)
                vc = 1
            }
        }
        vc_max = maxOf(vc_max, vc)

        // print("hc_max: $hc_max, vc_max: $vc_max\n")

        var cont = minOf(hc_max, vc_max)

        return (cont+1)*(cont+1)
    }
}
