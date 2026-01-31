package cp

// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/description/
class Solution_2148 {
    fun countElements(nums: IntArray): Int {
        if (nums.size < 3) {
            return 0
        }

        // return ansWithSort(nums)
        return ansWithoutSort(nums)
    }

    fun ansWithoutSort(nums: IntArray): Int {
        var mini = nums[0]
        var maxi = nums[0]

        for (i in 1 until nums.size) {
            mini = minOf(mini, nums[i])
            maxi = maxOf(maxi, nums[i])
        }

        var ans = 0
        for (i in 0 until nums.size) {
            if (nums[i]>mini && nums[i]<maxi) {
                ans++
            }
        }
        return ans
    }

    fun ansWithSort(nums: IntArray): Int {
        nums.sort()
        if (nums[0] == nums[nums.size-1]) {
            return 0
        }

        var ans = nums.size-2
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i-1]) {
                ans--
            } else {
                break
            }
        }
        for (i in nums.size-2 downTo 0) {
            if (nums[i] == nums[i+1]) {
                ans--
            } else {
                break
            }
        }

        return ans
    }
}
