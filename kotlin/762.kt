package cp

//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/?envType=problem-list-v2&envId=bit-manipulation
class Solution_762 {
    fun countPrimeSetBits(left: Int, right: Int): Int {
        var ans = 0

        for (i in left..right) {
            if (hasPrimeSetBits(i)) {
                ans++
            }
        }

        return ans
    }

    fun hasPrimeSetBits(num: Int): Boolean {
        val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19)

        return countSetBits(num) in primes
    }

    fun countSetBits(number: Int): Int {
        var num = number
        var count = 0
        while (num>0) {
            count++
            num = num and (num-1)
        }
        return count
    }
}
