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

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// https://leetcode.com/problems/middle-of-the-linked-list/description/?envType=problem-list-v2&envId=linked-list
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while(fast != null) {
            if (fast.next == null) {
                return slow
            }
            if (fast.next.next == null) {
                return slow!!.next
            }
            slow = slow?.next
            fast = fast.next.next
        }
        return slow
    }
}
