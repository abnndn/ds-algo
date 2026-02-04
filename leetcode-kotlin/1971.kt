package cp

// https://leetcode.com/problems/find-if-path-exists-in-graph/description/?envType=problem-list-v2&envId=graph
class Solution_1971 {
    fun validPath(n: Int,
                  edges: Array<IntArray>,
                  source: Int,
                  destination: Int): Boolean {
        val graph = Array(n) { mutableListOf<Int>() }

        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        val visited = BooleanArray(n) { false }
        return found(source, destination, graph, visited)
    }

    fun found(curr: Int,
              dest: Int,
              graph: Array<MutableList<Int>>,
              visited: BooleanArray): Boolean {
        if (curr == dest) {
            return true
        }
        if (visited[curr]) {
            return false
        }
        visited[curr] = true
        var yes = false
        for (i in 0 until graph[curr].size) {
            yes = yes || found(graph[curr][i], dest, graph, visited)
        }

        return yes
    }
}
