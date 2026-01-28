package cp

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/?envType=problem-list-v2&envId=tree

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
class Solution_653 {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        return recurAll(root, root, k)
    }

    fun recurAll(root: TreeNode?, curr: TreeNode?, num: Int): Boolean {
        if (curr == null) {
            return false
        }
        if (findNum(root, num-curr.`val`, curr)) {
            return true
        }
        return recurAll(root, curr.left, num) || recurAll(root, curr.right, num)
    }

    fun findNum(curr: TreeNode?, num: Int, notThis: TreeNode?): Boolean {
        if (curr == null) {
            return false
        }
        if (curr.`val` == num && curr != notThis) {
            return true
        }
        if (curr.`val` > num) {
            return findNum(curr.left, num, notThis)
        }
        if (curr.`val` < num) {
            return findNum(curr.right, num, notThis)
        }
        return false
    }
}
