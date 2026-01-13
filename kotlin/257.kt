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

class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
}

// https://leetcode.com/problems/binary-tree-paths/submissions/1883591878/?envType=problem-list-v2&envId=depth-first-search
class Solution_257 {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val ans = mutableListOf<String>()
        recur(ans, root, "")
        return ans.toList()
    }

    fun recur(ans: MutableList<String>, root: TreeNode?, curr: String) {
        if (root == null) {
            return
        }
        val new_curr = if (curr == "") {"${root.`val`}"} else {"$curr->${root.`val`}"}

        if (root.left == null && root.right == null) {
            ans.add(new_curr)
        }
        if (root.left != null) {
            recur(ans, root.left, new_curr)
        }
        if (root.right != null) {
            recur(ans, root.right, new_curr)
        }
    }
}
class `257` {
}
