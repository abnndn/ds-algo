package cp

// https://leetcode.com/problems/minimum-height-trees/?envType=problem-list-v2&envId=graph
class Solution_310 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val dir = IntArray(n)
        val graph = Array(n) { mutableListOf<Int>() }

        if (n == 1) {
            return listOf(0)
        }

        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])

            dir[edge[0]]++
            dir[edge[1]]++
        }

        val deque = ArrayDeque<Int>()

        for (i in 0 until dir.size) {
            if (dir[i] == 1) {
                deque.addLast(i)
            }
        }

        var first = deque.first()
        var second = first
        while(deque.size > 0) {
            val curr = deque.removeFirst()
            second = first
            first = curr

            dir[curr] = 0
            for (i in 0 until graph[curr].size) {
                if (dir[graph[curr][i]] == 0) {
                    continue
                }
                dir[graph[curr][i]]--
                if (dir[graph[curr][i]] == 1) {
                    deque.addLast(graph[curr][i])
                }
            }
        }

        var vis1 = IntArray(n) { -1 }
        val ff = findHeight(graph, first, vis1)
        var vis2 = IntArray(n) { -1 }
        val ss = findHeight(graph, second, vis2)

        if (ff == ss) {
            return listOf(first, second)
        }
        return listOf(first)
    }

    fun findHeight(graph: Array<MutableList<Int>>, node: Int, visited: IntArray): Int {
        if (visited[node] > 0) {
            return visited[node]
        }
        if (visited[node] == 0) {
            return Int.MIN_VALUE
        }
        visited[node] = 0

        var height = 0
        for (i in 0 until graph[node].size) {
            height = maxOf(height, findHeight(graph, graph[node][i], visited))
        }
        visited[node] = height+1

        return height+1
    }
}
