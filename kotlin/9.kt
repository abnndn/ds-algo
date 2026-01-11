package cp

// https://leetcode.com/problems/palindrome-number/
class Solution_9 {
    fun isPalindrome(x: Int): Boolean {
        if (x<0) {
            return false
        }

        var seedha_x = x
        var ulta_x = 0

        while (seedha_x > 0) {
            ulta_x = ulta_x*10 + seedha_x%10
            seedha_x /= 10
        }

        // print("x: $x\n")
        // print("ulta_x: $ulta_x\n")
        return x == ulta_x
    }
}
