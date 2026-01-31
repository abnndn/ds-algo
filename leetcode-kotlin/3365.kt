package cp

// https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/submissions/1902755213/
class Solution_3365 {
    fun isPossibleToRearrange(s: String, t: String, k: Int): Boolean {
        if (s.length%k != 0 && s.length != t.length) {
            return false
        }

        val chunk = s.length/k
        val sss = s.chunked(chunk)
        val ttt = t.chunked(chunk)

        val mm = mutableMapOf<String, Int>()
        for (ss in sss) {
            if (mm.contains(ss)) {
                mm[ss] = mm[ss]!! + 1
            } else {
                mm[ss] = 1
            }
        }
        for (tt in ttt) {
            if (mm.contains(tt) && mm[tt]!!>0) {
                mm[tt] = mm[tt]!! - 1
            } else {
                return false
            }
        }
        return true
    }
}
