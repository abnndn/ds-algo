package cp

// https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/?envType=daily-question&envId=2026-02-01
class Solution_3010 {
    fun minimumCost(nums: IntArray): Int {
        var one = nums[0]
        var two = nums[0]
        for (i in 1 until nums.size) {
            if (one < nums[i]) {
                one = nums[i]
            }
            if (two < nums[i]) {
                two = nums[i]
            }
        }

        for (i in 1 until nums.size) {
            if (one > nums[i]) {
                two = one
                one = nums[i]
            } else if (two > nums[i]) {
                two = nums[i]
            }
        }

        return nums[0] + one + two
    }
}
