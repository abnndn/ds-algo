package cp

// https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/?envType=daily-question&envId=2026-01-16
class Solution_2975 {
    fun maximizeSquareArea(m: Int, n: Int, hor: IntArray, ver: IntArray): Int {
        hor.sort()
        ver.sort()

        val dh = mutableListOf<Int>()
        dh.add(m-1)
        for (i in 0 until hor.size) {
            dh.add(hor[i]-1)
            for (j in 0 until i) {
                dh.add(hor[i]-hor[j])
            }
            dh.add(m-hor[i])
        }

        val dv = mutableListOf<Int>()
        dv.add(n-1)
        for (i in 0 until ver.size) {
            dv.add(ver[i]-1)
            for (j in 0 until i) {
                dv.add(ver[i]-ver[j])
            }
            dv.add(n-ver[i])
        }

        // print("m: $m, dh: [")
        // for (h in dh) {
        //     print("$h,")
        // }
        // print("]\n")
        // print("n: $n, dv: [")
        // for (v in dv) {
        //     print("$v,")
        // }
        // print("]\n")

        dh.sort()
        dv.sort()

        // print("m: $m, dh: [")
        // for (h in dh) {
        //     print("$h,")
        // }
        // print("]\n")
        // print("n: $n, dv: [")
        // for (v in dv) {
        //     print("$v,")
        // }
        // print("]\n")

        var ans: Long = -1L

        var i = 0
        var j = 0
        while (i < dh.size && j < dv.size) {
            if (dh[i] == dv[j]) {
                ans = maxOf(ans, dh[i].toLong())
                i++
                j++
            } else if (dh[i] > dv[j]) {
                j++
            } else {
                i++
            }
        }

        if (ans == -1L) {
            return ans.toInt()
        }
        return ((ans*ans)%1000000007).toInt()
    }
}
