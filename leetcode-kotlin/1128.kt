package cp

// https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
class Solution_1128 {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        for (domino in dominoes) {
            domino.sort()
        }
        dominoes.sortWith(compareBy({it[0]}, {it[1]}))

        var ans = 0

        var start = 0
        while(start < dominoes.size) {
            var end = start
            while(end+1<dominoes.size &&
                dominoes[start][0]==dominoes[end+1][0] &&
                dominoes[start][1]==dominoes[end+1][1]) {
                end++
            }
            if (start < end) {
                var size = end-start+1
                ans += size*(size-1)/2
            }

            start = end+1
        }

        return ans
    }
}
