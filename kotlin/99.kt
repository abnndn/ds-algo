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

// https://leetcode.com/problems/recover-binary-search-tree/?envType=problem-list-v2&envId=tree
class Solution_99 {
    val array = mutableListOf<Int>()
    var index = 0
    fun recoverTree(root: TreeNode?) {
        inOrder(root)

        val newArray = array.toIntArray()
        newArray.sort()

        for (i in array.indices) {
            if (array[i] != newArray[i]) {
                index = 0
                change(root, i, newArray[i])
            }
        }
    }

    fun change(root: TreeNode?, targetIndex: Int, value: Int) {
        if (index > targetIndex) {
            return
        }
        if (root == null) {
            return
        }
        change(root.left, targetIndex, value)
        if (index == targetIndex) {
            root.`val` = value
        }
        index++
        change(root.right, targetIndex, value)
    }

    fun inOrder(root: TreeNode?) {
        if (root == null) {
            return
        }
        inOrder(root.left)
        array.add(root.`val`)
        inOrder(root.right)
    }
}
