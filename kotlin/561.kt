package cp

// https://leetcode.com/problems/array-partition/description/?envType=problem-list-v2&envId=greedy
class Solution_561 {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()

        var ans = 0
        for (i in nums.indices step 2) {
            ans += nums[i]
        }

        return ans
    }
}

