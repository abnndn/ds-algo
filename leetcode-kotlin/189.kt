package cp

// https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
class Solution_189 {
    fun rotate(nums: IntArray, k: Int) {
        rotate_beautiful_o1(nums, k%nums.size)
        // rotate_extra_space(nums, k%nums.size)
    }

    fun rotate_extra_space(nums: IntArray, k: Int) {
        val res = IntArray(nums.size)

        var first = 0
        var second = k
        while (first < nums.size) {
            res[second] = nums[first]
            first++
            second = (second+1)%nums.size
        }

        for (i in nums.indices) {
            nums[i] = res[i]
        }
    }

    // Good solution - https://leetcode.com/problems/rotate-array/solutions/3506340/beats-100-3-line-solution-fully-most-opt-8uci/
    fun rotate_beautiful_o1(nums: IntArray, k: Int) {
        reverse(nums, nums.size-k, nums.size-1)
        reverse(nums, 0, nums.size-k-1)
        reverse(nums, 0, nums.size-1)
    }

    fun reverse(nums: IntArray, start_index: Int, end_index: Int) {
        var start = start_index
        var end = end_index
        var temp = 0
        while (start < end) {
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start++
            end--
        }
    }
}
