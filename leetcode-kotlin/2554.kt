// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
package cp

class Solution_2554 {
    fun maxCount(banned: IntArray, n: Int, mSum: Int): Int {
        banned.sort()

        var count = 0

        var index = 0
        var maxSum = mSum
        for (i in 1 until n+1) {
            while(index < banned.size && banned[index] < i) {
                index++
            }
            if (index<banned.size && banned[index] == i) {
                index++
                continue
            }
            if (maxSum-i < 0) {
                break
            }
            count++
            maxSum -= i
        }

        return count
    }
}
