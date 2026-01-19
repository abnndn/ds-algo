package cp

// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/description/?envType=daily-question&envId=2026-01-19
class Solution_1292 {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        // var minValue = Int.MAX_VALUE
        // for (i in mat.indices) {
        //     for (j in mat[i].indices) {
        //         minValue = minOf(minValue, mat[i][j])
        //     }
        // }

        // if (minValue > threshold) {
        //     return 0
        // }

        val presum = Array(mat.size) { IntArray(mat[0].size) }
        populatePresum(mat, presum)

        var ans = 0
        for (i in 0 until mat.size) {
            for (j in 0 until mat[i].size) {
                ans = maxOf(ans, biggestSquare(mat, presum, threshold, i, j))
            }
        }

        return ans
    }

    fun populatePresum(mat: Array<IntArray>, presum: Array<IntArray>) {
        val row = mat.size
        val col = mat[0].size

        val hor = Array(row) { IntArray(col) }
        val ver = Array(row) { IntArray(col) }

        for (i in 0 until row) {
            hor[i][0] = mat[i][0]
            for (j in 1 until col) {
                hor[i][j] = hor[i][j-1] + mat[i][j]
            }
        }
        for (j in 0 until col) {
            ver[0][j] = mat[0][j]
            for (i in 1 until row) {
                ver[i][j] = ver[i-1][j] + mat[i][j]
            }
        }

        for (i in 0 until row) {
            presum[i][0] = ver[i][0]
        }
        for (j in 0 until col) {
            presum[0][j] = hor[0][j]
        }
        for (i in 1 until row) {
            for (j in 1 until col) {
                presum[i][j] = presum[i-1][j-1] + mat[i][j] + hor[i][j-1] + ver[i-1][j]
            }
        }
        // for (i in 0 until row) {
        //     print("$i: [")
        //     for (j in 0 until col) {
        //         print("${presum[i][j]},")
        //     }
        //     print("]\n")
        // }
    }

    fun biggestSquare(mat: Array<IntArray>, presum: Array<IntArray>, threshold: Int, er: Int, ec: Int): Int {
        var found = 0

        var sr = er-1
        var sc = ec-1
        while(sr>=0 && sc>=0) {
            if (presum[er][ec] + presum[sr][sc] - presum[sr][ec] - presum[er][sc] <= threshold) {
                found = er-sr
            }
            sr--
            sc--
        }
        if (sr == -1 && sc == -1) {
            if (presum[er][ec] <= threshold) {
                found = er+1
            }
        } else if (sr == -1) {
            if (presum[er][ec] - presum[er][sc] <= threshold) {
                found = er+1
            }
        } else if (sc == -1) {
            if (presum[er][ec] - presum[sr][ec] <= threshold) {
                found = ec+1
            }
        }

        return found
    }
}
