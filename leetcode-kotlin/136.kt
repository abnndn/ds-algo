package cp

//https://leetcode.com/problems/single-number/?envType=problem-list-v2&envId=bit-manipulation
class Solution_136 {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0

        for (i in nums.indices) {
            ans = ans xor nums[i]
        }

        return ans
    }
}
