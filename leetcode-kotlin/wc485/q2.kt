package cp.wc485

// https://leetcode.com/problems/maximum-capacity-within-budget/
class Solution {
    fun maxCapacity(costs: IntArray, capacity: IntArray, budget: Int): Int {
        val info = mutableListOf<MutableList<Int>>()

        var ans = 0
        for (i in 0 until costs.size) {
            if (costs[i] < budget) {
                ans = maxOf(ans, capacity[i])
                info.add(mutableListOf(costs[i], capacity[i], capacity[i]))
            }
        }
        info.sortBy { it[0] }

        // print("Info: ")
        // for (i in 0 until info.size) {
        //     print("[${info[i][0]}, ${info[i][1]}]; ")
        // }
        // print("\n")

        var maxi = 0
        for (i in 0 until info.size) {
            if (maxi < info[i][1]) {
                maxi = info[i][1]
            }
            info[i][2] = maxi
        }
        // print("Info: ")
        // for (i in 0 until info.size) {
        //     print("[${info[i][0]}, ${info[i][1]}, ${info[i][2]}]; ")
        // }
        // print("\n")

        var needed: Int
        var low: Int
        var high: Int
        var mid: Int
        var found: Int
        for (i in info.size-1 downTo 1) {
            needed = budget - info[i][0] - 1
            low = 0
            high = i-1
            found = -1

            while(low <= high) {
                mid = (low+high)/2
                if (info[mid][0] > needed) {
                    high = mid-1
                } else {
                    found = mid
                    low = mid+1
                }
            }

            if (found != -1) {
                // print("$i, $found: ${info[i][1] + info[found][2]}\n")
                ans = maxOf(info[i][1] + info[found][2], ans)
            }
        }

        return ans
    }
}
