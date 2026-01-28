package cp

// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/?envType=problem-list-v2&envId=prefix-sum
class Solution_1508 {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val module: Int = 1000000007

        val presum = LongArray(n)
        presum[0] = nums[0].toLong()
        for (i in 1 until n) {
            presum[i] = (nums[i].toLong()+presum[i-1]) % module
        }

        // print("Presum:[")
        // for (i in presum.indices) {
        //     print("${presum[i]},")
        // }
        // print("]\n")

        val size: Int = (n*(n+1))/2
        var index = 0
        val subs = LongArray(size)
        for (i in 0 until n) {
            for (j in i until n) {
                if (i==0) {
                    subs[index++] = presum[j]
                } else {
                    subs[index++] = presum[j]-presum[i-1]
                }
            }
        }
        subs.sort()

        // print("Subs:[")
        // for (i in subs.indices) {
        //     print("${subs[i]},")
        // }
        // print("]\n")

        var ans: Long = 0L
        for (i in left-1 until right) {
            ans = (ans + subs[i])%module
        }
        return ans.toInt()
    }
}
