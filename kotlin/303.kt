package cp

//https://leetcode.com/problems/range-sum-query-immutable/description/?envType=problem-list-v2&envId=prefix-sum
class NumArray_303(nums: IntArray) {

    val presum = IntArray(nums.size)

    init {
        presum[0] = nums[0]
        for (i in 1 until nums.size) {
            presum[i] = presum[i-1] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        if (left == 0) {
            return presum[right]
        }
        return presum[right]-presum[left-1]
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
