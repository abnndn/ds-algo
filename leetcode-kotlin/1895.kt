package cp

// https://leetcode.com/problems/largest-magic-square/description/?envType=daily-question&envId=2026-01-18
class Solution_1895 {

    fun checker(grid: Array<IntArray>, sr: Int, sc: Int, er: Int, ec: Int): Boolean {
        var sum = 0
        for (i in sr..er) {
            sum += grid[i][sc]
        }

        var curr: Int = 0
        for (i in sr..er) {
            curr = 0
            for (j in sc..ec) {
                curr += grid[i][j]
            }
            if (curr != sum) {
                return false
            }
        }
        for (j in sc..ec) {
            curr = 0
            for (i in sr..er) {
                curr += grid[i][j]
            }
            if (curr != sum) {
                return false
            }
        }

        var r = sr
        var c = sc
        curr = 0
        while(r<=er && c<=ec) {
            curr += grid[r][c]
            r++
            c++
        }
        if (curr != sum) {
            return false
        }

        r = sr
        c = ec
        curr = 0
        while(r<=er && c>=sc) {
            curr += grid[r][c]
            r++
            c--
        }
        if (curr != sum) {
            return false
        }

        // print("$sr, $sc: $er, $ec\n")
        return true
    }

    fun largestMagicSquare(grid: Array<IntArray>): Int {
        val row = grid.size
        val col = grid[0].size

        var ans = 1
        for (i in 0 until row) {
            for (j in 0 until col) {
                var size = 1
                while (i+size < row && j+size < col) {
                    if (checker(grid, i, j, i+size, j+size)) {
                        ans = maxOf(ans, size+1)
                    }
                    size++
                }
                // print("checking: $i, $j: $ans \n")
            }
        }

        return ans
    }
}
