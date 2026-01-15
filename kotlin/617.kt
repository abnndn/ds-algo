package cp

// https://leetcode.com/problems/merge-two-binary-trees/?envType=problem-list-v2&envId=tree

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
class Solution_617 {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null && root2 == null) {
            return null
        }
        if (root1 == null) {
            return root2
        }
        if (root2 == null) {
            return root1
        }
        val newNode = TreeNode(root1.`val` + root2.`val`)
        newNode.left = mergeTrees(root1.left, root2.left)
        newNode.right = mergeTrees(root1.right, root2.right)

        return newNode
    }
}
