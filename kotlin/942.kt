package cp

// https://leetcode.com/problems/di-string-match/description/?envType=problem-list-v2&envId=greedy
class Solution_942 {
    fun diStringMatch(s: String): IntArray {
        val ans = IntArray(s.length+1) { -1 }

        var valueI = 0
        var valueD = s.length
        for (i in 0 until s.length) {
            if (s[i] == 'I') {
                ans[i] = valueI++
            } else {
                ans[i] = valueD--
            }
        }
        ans[s.length] = valueI

        return ans
    }
}
