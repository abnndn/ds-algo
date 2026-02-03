package cp

// https://leetcode.com/problems/trionic-array-i/description/?envType=daily-question&envId=2026-02-03
class Solution_3637 {
    fun isTrionic(nums: IntArray): Boolean {
        var index = 0
        while(index+1 < nums.size) {
            if (nums[index] == nums[index+1]) {
                return false
            }
            if (nums[index] > nums[index+1]) {
                break
            }
            index++
        }
        // print("Index 1: $index\n")

        if (index == 0) {
            return false
        }
        if (index+1 >= nums.size) {
            return false
        }
        while(index+1 < nums.size) {
            if (nums[index] == nums[index+1]) {
                return false
            }
            if (nums[index] < nums[index+1]) {
                break
            }
            index++
        }
        // print("Index 2: $index\n")
        if (index+1 >= nums.size) {
            return false
        }
        while(index+1 < nums.size) {
            if (nums[index] == nums[index+1]) {
                return false
            }
            if (nums[index] > nums[index+1]) {
                break
            }
            index++
        }
        // print("Index 3: $index\n")

        return index+1 == nums.size
    }
}
