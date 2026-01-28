package cp.wc486

// https://leetcode.com/contest/weekly-contest-486/problems/rotate-non-negative-elements/
class Solution {
    fun rotateElements(nums: IntArray, k: Int): IntArray {
        val pos = mutableListOf<Int>()

        for (num in nums) {
            if (num >= 0) {
                pos.add(num)
            }
        }

        if (pos.size == 0) {
            return nums
        }

        var shift = k
        shift = shift%pos.size

        var i = 0
        var j = shift-1
        while(i<j) {
            pos[i] = pos[i] xor pos[j]
            pos[j] = pos[i] xor pos[j]
            pos[i] = pos[i] xor pos[j]
            i++
            j--
        }

        i = shift
        j = pos.size-1
        while(i<j) {
            pos[i] = pos[i] xor pos[j]
            pos[j] = pos[i] xor pos[j]
            pos[i] = pos[i] xor pos[j]
            i++
            j--
        }

        i = 0
        j = pos.size-1
        while(i<j) {
            pos[i] = pos[i] xor pos[j]
            pos[j] = pos[i] xor pos[j]
            pos[i] = pos[i] xor pos[j]
            i++
            j--
        }

        var index = 0
        for (i in nums.indices) {
            if (nums[i] >= 0) {
                nums[i] = pos[index]
                index++
            }
        }

        return nums
    }
}
