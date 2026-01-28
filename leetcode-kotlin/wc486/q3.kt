package cp.wc486

// https://leetcode.com/contest/weekly-contest-486/problems/pythagorean-distance-nodes-in-a-tree/
class Solution {
    fun specialNodes(n: Int, edges: Array<IntArray>, x: Int, y: Int, z: Int): Int {

        val create_tree = mutableMapOf<Int, MutableList<Int>>()

        for (edge in edges) {
            create_tree.getOrPut(edge[0]) {mutableListOf() }.add(edge[1])
            create_tree.getOrPut(edge[1]) {mutableListOf() }.add(edge[0])
        }
        val tree = create_tree.mapValues { it.value.toList() }

        val vis = BooleanArray(n)

        val xx = IntArray(n) { Int.MAX_VALUE }
        distance(x, 0, vis, xx, tree)

        val yy = IntArray(n) { Int.MAX_VALUE }
        vis.fill(false)
        distance(y, 0, vis, yy, tree)

        val zz = IntArray(n) { Int.MAX_VALUE }
        vis.fill(false)
        distance(z, 0, vis, zz, tree)

        var ans = 0
        val comp = LongArray(3)
        for (i in 0 until n) {
            comp[0] = xx[i].toLong()
            comp[1] = yy[i].toLong()
            comp[2] = zz[i].toLong()

            comp.sort()

            if (comp[0]*comp[0] + comp[1]*comp[1] == comp[2]*comp[2]) {
                ans++
            }
        }

        return ans
    }

    fun distance(currNode: Int,
                 currDist: Int,
                 vis: BooleanArray,
                 dist: IntArray,
                 tree: Map<Int, List<Int>>) {
        if (vis[currNode]) {
            return
        }
        vis[currNode] = true
        dist[currNode] = currDist

        for (nextNode in tree[currNode] ?: emptyList()) {
            distance(nextNode, currDist+1, vis, dist, tree)
        }
    }
}
