package cp

// https://leetcode.com/problems/binary-number-with-alternating-bits/description/?envType=problem-list-v2&envId=bit-manipulation
class Solution_693 {
    fun hasAlternatingBits(n: Int): Boolean {
        return ((n xor (n shr 1)) and ((n xor (n shr 1)) + 1)) == 0
    }
}
