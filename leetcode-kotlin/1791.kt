package cp

// https://leetcode.com/problems/find-center-of-star-graph/?envType=problem-list-v2&envId=graph
class Solution_1791 {
    fun findCenter(edges: Array<IntArray>): Int {
        val node = edges.size + 1
        val edge = IntArray(node+1) { 0 }

        for (e in edges) {
            edge[e[0]]++
            edge[e[1]]++

            if (edge[e[0]]>1) {
                return e[0]
            }
            if (edge[e[1]]>1) {
                return e[1]
            }
        }

        // for (i in 1 until node+1) {
        //     if (edge[i] == node-1) {
        //         return i
        //     }
        // }

        return -1
    }
}
