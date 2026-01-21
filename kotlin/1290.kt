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

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/?envType=problem-list-v2&envId=linked-list
class Solution_1290 {
    fun getDecimalValue(header: ListNode?): Int {
        var ans = 0
        var head = header
        while(head != null) {
            ans = ans*2 + head.`val`
            head = head.next
        }

        return ans
    }
}
