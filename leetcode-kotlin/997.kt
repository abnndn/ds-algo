package cp

// https://leetcode.com/problems/find-the-town-judge/?envType=problem-list-v2&envId=graph
class Solution_997 {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        var trusts = IntArray(n+1) { 0 }
        var trustedBy = IntArray(n+1) { 0 }

        for (t in trust) {
            trusts[t[0]]++
            trustedBy[t[1]]++
        }

        // for (i in 1 until n+1) {
        //     print("[$i: ${trusts[i]}, ${trustedBy[i]}], ")
        // }
        // print("\n")

        var ans = -1
        for (i in 1 until n+1) {
            if (trusts[i] == 0 && trustedBy[i] == n-1) {
                if (ans != -1) {
                    return -1
                }
                ans = i
                continue
            }
            if (trusts[i] == 0) {
                return -1
            }
        }
        return ans
    }
}
