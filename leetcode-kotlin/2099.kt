package cp

import java.util.PriorityQueue

//https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/?envType=problem-list-v2&envId=heap-priority-queue
class Solution_2099 {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val heap = PriorityQueue<IntArray> { a, b -> a[1].compareTo(b[1]) }

        for (i in 0 until k) {
            heap.add(intArrayOf(i, nums[i]))
        }
        for (i in k until nums.size) {
            if (nums[i] > heap.peek()[1]) {
                heap.poll()
                heap.add(intArrayOf(i, nums[i]))
            }
        }
        val calc = heap.toTypedArray()
        calc.sortBy { it[0] }

        val ans = IntArray(k)
        for (i in 0 until k) {
            ans[i] = calc[i][1]
        }
        return ans
    }
}
