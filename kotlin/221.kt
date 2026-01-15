package cp

// https://leetcode.com/problems/maximal-square/description/
class Solution_221 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        return dp_try(matrix)
    }

    fun dp_try(matrix: Array<CharArray>): Int {
        val hor = Array(matrix.size) { IntArray(matrix[0].size) }
        val ver = Array(matrix.size) { IntArray(matrix[0].size) }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        ver[i][j] = 1
                    } else {
                        ver[i][j] = ver[i-1][j]+1
                    }

                    if (j == 0) {
                        hor[i][j] = 1
                    } else {
                        hor[i][j] = hor[i][j-1]+1
                    }
                }
            }
        }


        // for (i in matrix.indices) {
        //     print("[")
        //     for (j in matrix[i].indices) {
        //         print("{${hor[i][j]},${ver[i][j]}}")
        //     }
        //     print("]\n")
        // }

        var maxFound = 0
        var currFound = 0
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                if (hor[row][col]>0 && ver[row][col]>0) {
                    currFound = 1
                    var i = row+1
                    var j = col+1

                    while (i<matrix.size && j<matrix[i].size) {
                        if (hor[i][j]>currFound && ver[i][j]>currFound) {
                            currFound++
                        } else {
                            break
                        }
                        i++
                        j++
                    }
                    // print("$row, $col: $currFound \n")
                }
                maxFound = maxOf(maxFound, currFound)
            }
        }

        return maxFound*maxFound
    }
}
