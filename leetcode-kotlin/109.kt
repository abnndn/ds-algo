package cp

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/?envType=problem-list-v2&envId=binary-search-tree
class Solution_109 {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        var input = mutableListOf<Int>()

        var temp = head
        while(temp != null) {
            input.add(temp.`val`)
            temp = temp.next
        }

        return create(input, 0, input.size-1)
    }

    fun create(input: List<Int>, start: Int, end: Int): TreeNode? {
        if (start == end) {
            return TreeNode(input[start])
        }
        if (start>end) {
            return null
        }
        var mid = (start+end)/2

        var curr = TreeNode(input[mid])
        curr.left = create(input, start, mid-1)
        curr.right = create(input, mid+1, end)

        return curr
    }
}
