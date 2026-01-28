package cp

// https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/description/?envType=daily-question&envId=2026-01-21
class Solution_3315 {
    fun minBitwiseArray(nums: List<Int>): IntArray {
        val ans = IntArray(nums.size)

        for (i in nums.indices) {
            if (nums[i]%2 == 0) {
                ans[i] = -1
                continue
            }

            val bin = mutableListOf<Int>()
            var allOne = true

            var num = nums[i]
            while(num>0) {
                if (num%2 == 0) {
                    allOne = false
                }
                bin.add(num%2)
                num /= 2
            }

            if (allOne) {
                ans[i] = (1 shl (bin.size-1)) - 1
                continue
            } else {
                for (j in 1 until bin.size) {
                    if (bin[j] == 0) {
                        bin[j-1] = 0
                        break
                    }
                }
            }

            var found = false
            for (j in bin.size-1 downTo 0) {
                if (found) {
                    ans[i] = ans[i]*2 + bin[j]
                } else if (bin[j] == 1) {
                    found = true
                    ans[i] = 1
                }
            }
        }

        return ans
    }
}
