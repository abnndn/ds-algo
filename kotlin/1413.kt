package cp

import kotlin.math.abs

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/?envType=problem-list-v2&envId=prefix-sum
class Solution_1413 {
    fun minStartValue(nums: IntArray): Int {
        var presum: Int = 0
        var min: Int = 1

        for (i in nums.indices) {
            presum += nums[i]

            if (presum < min) {
                min = presum
            }
            // print("$i:$presum, ")
        }

        if (min >= 0) {
            return 1
        }
        return abs(min) + 1
    }
}
