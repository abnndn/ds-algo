package cp

// https://leetcode.com/problems/assign-cookies/description/?envType=problem-list-v2&envId=greedy
class Solution_455 {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()

        var ans = 0

        var index = 0
        for (need in g) {
            while(index < s.size) {
                if (s[index] >= need) {
                    ans++
                    index++
                    break
                }
                index++
            }
        }

        return ans
    }
}
