package cp

// https://leetcode.com/problems/average-of-levels-in-binary-tree/?envType=problem-list-v2&envId=tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution_637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val queue = ArrayDeque<TreeNode>()
        val ans = mutableListOf<Double>()

        if (root != null) {
            queue.addLast(root)
        }
        while(queue.isNotEmpty()) {
            val size = queue.size
            var total: Double = 0.0
            for (i in 0 until size) {
                val curr = queue.removeFirst()
                total = total + (curr.`val`).toDouble()

                if (curr.left != null) {
                    queue.addLast(curr.left)
                }
                if (curr.right != null) {
                    queue.addLast(curr.right)
                }
            }
            ans.add(total/size)
        }


        return ans.toDoubleArray()
    }
}
