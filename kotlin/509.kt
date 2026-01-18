package cp

// https://leetcode.com/problems/fibonacci-number/description/?envType=problem-list-v2&envId=dynamic-programming
class Solution_509 {
    fun fib(n: Int): Int {
        if (n < 2) {
            return n
        }
        var first = 1
        var second = 1
        var temp = 0

        for (i in 3..n) {
            temp = first
            first = second
            second = temp+first
        }
        return second
    }
}
