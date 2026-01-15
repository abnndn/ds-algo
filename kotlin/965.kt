package cp

// https://leetcode.com/problems/univalued-binary-tree/description/?envType=problem-list-v2&envId=tree

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
class Solution_965 {
    fun isUnivalTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val value = root.`val`
        return checker(root, value)
    }

    fun checker(root: TreeNode?, value: Int): Boolean {
        if (root == null) {
            return true
        }
        if (root.`val` != value) {
            return false
        }
        return checker(root.left, value) && checker(root.right, value)
    }
}
