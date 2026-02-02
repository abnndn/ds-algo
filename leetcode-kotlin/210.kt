package cp

// https://leetcode.com/problems/course-schedule-ii/?envType=problem-list-v2&envId=graph
class Solution_210 {
    fun findOrder(courses: Int, preq: Array<IntArray>): IntArray {
        val degree = IntArray(courses) { 0 }
        val sides = Array(courses) { mutableListOf<Int>() }

        for (pre in preq) {
            sides[pre[1]].add(pre[0])
            degree[pre[0]]++
        }

        val deque = ArrayDeque<Int>()
        val result = mutableListOf<Int>()

        for (i in 0 until courses) {
            if (degree[i] == 0) {
                deque.addLast(i)
            }
        }

        while (deque.size > 0) {
            var curr = deque.removeFirst()
            result.add(curr)

            for (i in 0 until sides[curr].size) {
                degree[sides[curr][i]]--

                if (degree[sides[curr][i]] == 0) {
                    deque.addLast(sides[curr][i])
                }
            }
        }

        if (result.size < courses) {
            return intArrayOf()
        }
        return result.toIntArray()
    }
}
