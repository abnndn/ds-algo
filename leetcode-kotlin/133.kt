package cp

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */
// https://leetcode.com/problems/clone-graph/description/?envType=problem-list-v2&envId=graph
class Solution_133 {
    fun cloneGraph(node: Node?): Node? {
        val visited = Array<Node?>(102) { null }
        return clone(node, visited)
    }

    fun clone(node: Node?, visited: Array<Node?>): Node? {
        if (node == null) {
            return null
        }
        if (visited[node.`val`] != null) {
            return visited[node.`val`]
        }

        val nn = Node(node.`val`)
        visited[node.`val`] = nn

        for (neighbor in node.neighbors) {
            nn.neighbors.add(clone(neighbor, visited))
        }


        return nn
    }
}
