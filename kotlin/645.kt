package cp

// https://leetcode.com/problems/set-mismatch/submissions/1884726441/?envType=problem-list-v2&envId=bit-manipulation
class Solution_645 {
    fun findErrorNums(nums: IntArray): IntArray {

        var xoring = 0
        for (i in nums.indices) {
            xoring = xoring xor nums[i]
            xoring = xoring xor (i+1)
        }

        val firstBit = xoring and -xoring

        var zeros = 0
        var ones = 0
        for (i in nums.indices) {
            if (nums[i] and firstBit > 0) {
                ones = ones xor nums[i]
            } else {
                zeros = zeros xor nums[i]
            }

            if ((i+1) and firstBit > 0) {
                ones = ones xor (i+1)
            } else {
                zeros = zeros xor (i+1)
            }
        }

        var first = ones xor xoring
        var second = zeros xor xoring

        var found = false
        for (i in nums.indices) {
            if (nums[i] == first) {
                found = true
                break
            }
        }
        if (!found) {
            first = first xor second
            second = first xor second
            first = first xor second
        }

        return intArrayOf(first, second)
    }
}
