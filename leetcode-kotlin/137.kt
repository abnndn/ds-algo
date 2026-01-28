package cp

// https://leetcode.com/problems/single-number-ii/description/?envType=problem-list-v2&envId=bit-manipulation
class Solution_137 {
    fun singleNumber(nums: IntArray): Int {
        val bits = IntArray(32)

        for (number in nums) {
            var index = 0
            var num = number
            while(index<32) {
                bits[index] += num and 1
                num = num shr 1
                index++
            }
        }
        bits.reverse()

        // print("Bits: [") for (bit in bits) { print("${bit}") } print("]\n")
        for (i in bits.indices) {
            bits[i] %= 3
        }
        // print("Bits: [") for (bit in bits) { print("${bit}") } print("]\n")

        var ans = 0
        for (bit in bits) {
            ans = (ans shl 1) or bit
        }

        return ans
    }
}
