package cp.wc486

// https://leetcode.com/contest/weekly-contest-486/problems/minimum-prefix-removal-to-make-array-strictly-increasing/description/
class Solution {
    fun minimumPrefixLength(nums: IntArray): Int {
        var index = nums.size-1

        while (index > 0) {
            if (nums[index]>nums[index-1]) {
                index--
            } else {
                break
            }
        }

        return index
    }
}
