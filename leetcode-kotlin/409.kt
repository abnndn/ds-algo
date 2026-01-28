package cp

// https://leetcode.com/problems/longest-palindrome/description/?envType=problem-list-v2&envId=greedy
class Solution_409 {
    fun longestPalindrome(s: String): Int {
        val counts = IntArray(256)
        for (char in s) {
            counts[char.code]++
        }

        var hasOdd = false
        var ans = 0

        for(value in counts) {
            if (value == 0) {
                continue
            }
            if (value%2 == 0) {
                ans += value
            } else {
                ans += value-1
                hasOdd = true
            }
        }

        if (hasOdd) {
            ans++
        }

        return ans
    }
}
