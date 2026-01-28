package cp

// https://leetcode.com/problems/reverse-integer/
class Solution_7 {

    fun reverse(x: Int): Int {
        if (x == 0 || x==Int.MIN_VALUE) {
            return 0
        }

        var ans = 0
        val isNeg: Boolean = x<0

        var xx = x
        if (isNeg) {
            xx *= -1
        }
        do {
            if (ans > Int.MAX_VALUE/10) {
                return 0
            }
            ans = ans*10 + xx%10
            xx /= 10
        } while (xx > 0)

        if (isNeg) {
            return ans * -1
        }
        return ans
    }

}

// Minimum: -2,147,483,648 ($-2^{31}$)
// Maximum: 2,147,483,647 ($2^{31} - 1$)
