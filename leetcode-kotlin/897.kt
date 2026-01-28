package cp

// https://leetcode.com/problems/increasing-order-search-tree/description/?envType=problem-list-v2&envId=tree

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
class Solution_897 {
    fun increasingBST(root: TreeNode?): TreeNode? {
        // return allLeftWrapper(root)
        return allRight(root)
    }

    fun allRight(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val leftNode: TreeNode?
        var node = TreeNode(root.`val`)

        if (root.right != null) {
            node.right = allRight(root.right)
        }

        if (root.left != null) {
            leftNode = allRight(root.left)
            var curr = leftNode
            while(curr!!.right != null) {
                curr = curr.right
            }
            curr.right = node
            node = leftNode!!
        }
        return node
    }

    fun allLeft(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val rightNode: TreeNode?
        var node = TreeNode(root.`val`)

        if (root.left != null) {
            node.left = allLeft(root.left)
        }
        if (root.right != null) {
            rightNode = allLeft(root.right)
            var curr = rightNode
            while(curr!!.left != null) {
                curr = curr.left
            }
            curr.left = node
            node = rightNode!!
        }
        return node
    }

    fun allLeftWrapper(root: TreeNode?): TreeNode? {
        var left = allLeft(root)

        if (left == null) {
            return null
        }

        var iter = left
        while(iter!!.left != null) {
            left = iter.left
            left.right = iter
            iter.left = null
            iter = left
        }

        return iter
    }
}
