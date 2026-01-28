package cp

// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
class Solution_1081 {
    fun smallestSubsequence(s: String): String {
        val index = IntArray(256) { -1 }
        for (i in 0 until s.length) {
            index[s[i].code] = i
        }

        val visited = BooleanArray(256)

        val stack = ArrayDeque<Char>()
        stack.addFirst(s[0])
        visited[s[0].code] = true
        for (i in 1 until s.length) {
            if (visited[s[i].code]) {
                continue
            }
            if (stack.size==0) {
                stack.addFirst(s[i])
                continue
            }
            while(stack.size>0 && stack.first().code>s[i].code && index[stack.first().code]>i) {
                visited[stack.removeFirst().code] = false
            }
            stack.addFirst(s[i])
            visited[s[i].code] = true
        }

        var ans = ""
        while(stack.size>0) {
            ans += stack.removeFirst()
        }
        return ans.reversed()
    }
}
