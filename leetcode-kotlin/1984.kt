package cp

// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/?envType=daily-question&envId=2026-01-25
class Solution_1984 {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        nums.sort()

        var ans = nums[nums.size-1]
        for (i in 0 until nums.size-k+1) {
            if (nums[i+k-1] - nums[i] < ans) {
                ans = nums[i+k-1]-nums[i]
            }
        }
        return ans
    }
}
