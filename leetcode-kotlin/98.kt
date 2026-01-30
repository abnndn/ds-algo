package cp

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

// https://leetcode.com/problems/validate-binary-search-tree/?envType=problem-list-v2&envId=tree
class Solution_98 {
    var last: Int? = null

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        var check: Boolean = true
        check = isValidBST(root.left)

        if (!check) {
            return check
        }
        if (last != null && last!! >= root.`val`) {
            return false
        }
        last = root.`val`

        check = isValidBST(root.right)
        return check
    }
}
