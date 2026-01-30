package cp.wc485

// https://leetcode.com/problems/vowel-consonant-score/description/
class Solution {
    fun vowelConsonantScore(s: String): Int {
        var v = 0
        var c = 0
        for (char in s) {
            if (char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u') {
                v++
            } else if (char>='a' && char<='z') {
                c++
            }
        }

        if (c == 0) {
            return 0
        }
        return v/c
    }
}
