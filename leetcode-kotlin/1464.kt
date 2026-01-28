package cp

// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/?envType=problem-list-v2&envId=heap-priority-queue
class Solution_1464 {
    fun maxProduct(nums: IntArray): Int {
        return onlyPos(nums)
    }

    fun onlyPos(nums: IntArray): Int {
        var first = nums[0]-1
        var second = nums[1]-1

        if (first < second) {
            first = second.also { second = first }
        }

        // print("1: $first, $second\n")
        for (i in 2 until nums.size) {
            if (nums[i]-1 >= first) {
                second = first
                first = nums[i]-1
            } else if (nums[i]-1 >= second) {
                second = nums[i]-1
            }
            // print("$i: $first, $second\n")
        }

        return first*second
    }

    fun withNeg(nums: IntArray): Int {
        var neg = 0
        var pos = 0
        for (i in nums.indices) {
            nums[i]--
            if (nums[i]>=0) {
                pos++
            } else {
                neg++
            }
        }
        nums.sort()

        var ans = 0
        if (neg>1) {
            ans = maxOf(ans, nums[0]*nums[1])
        }
        if (pos>1) {
            ans = maxOf(ans, nums[nums.size-1]*nums[nums.size-2])
        }
        return ans
    }
}
