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
// https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2026-02-09
class Solution {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val info = mutableListOf<Int>()
        iter(root, info)

        return create(info, 0, info.size-1)
    }

    fun create(info: MutableList<Int>, left: Int, right: Int): TreeNode? {
        if (left > right) {
            return null
        }
        val mid = (left+right)/2
        val node = TreeNode(info[mid])
        node.left = create(info, left, mid-1)
        node.right = create(info, mid+1, right)

        return node
    }

    fun iter(root: TreeNode?, info: MutableList<Int>) {
        if (root == null) {
            return
        }
        iter(root.left, info)
        info.add(root.`val`)
        iter(root.right, info)
    }
}
