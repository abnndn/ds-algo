package cp

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/?envType=daily-question&envId=2026-01-31
class Solution_744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var ans = letters[0]

        for (ch in letters) {
            if (ch > target) {
                ans = ch
                break
            }
        }

        return ans
    }
}
