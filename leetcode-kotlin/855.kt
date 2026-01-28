package cp

import java.util.PriorityQueue

// https://leetcode.com/problems/exam-room/?envType=problem-list-v2&envId=heap-priority-queue
class ExamRoom_855(val n: Int) {

    val heap = PriorityQueue<IntArray> { a, b ->
        if (a[2] != b[2]) {
            b[2].compareTo(a[2])
        } else {
            a[0].compareTo(b[0])
        }
    }

    init {
        heap.add(getElement(-1, n))
    }

    fun bestDiff(start: Int, end: Int): Int {
        if (start == -1 && end == n) {
            return n+1
        }
        if (start == -1) {
            return end
        }
        if (end == n) {
            return n-start-1
        }

        var gap: Int = end-start-1
        if (gap%2 == 0) {
            gap--
        }
        return gap
    }

    fun getElement(start: Int, end: Int): IntArray {
        return intArrayOf(start, end, bestDiff(start, end))
    }

    fun seat(): Int {
        val br = heap.poll()

        if (br[0] == -1) {
            heap.add(getElement(0, br[1]))
            return 0
        }
        if (br[1] == n) {
            heap.add(getElement(br[0], n-1))
            return n-1
        }

        val bs = br[0]+1+(br[2]/2)
        heap.add(getElement(br[0], bs))
        heap.add(getElement(bs, br[1]))

        return bs
    }

    fun leave(p: Int) {
        var start = -2
        var end = -2
        val iter = heap.iterator()
        while(iter.hasNext()) {
            val range = iter.next()
            if (range[0] == p) {
                end = range[1]
                iter.remove()
            } else if (range[1] == p) {
                start = range[0]
                iter.remove()
            }
        }

        if (start != -2 && end != -2) {
            heap.add(getElement(start, end))
            return
        }
        if (start != -2) {
            heap.add(getElement(start, n))
        }
        if (end != -2) {
            heap.add(getElement(-1, end))
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * var obj = ExamRoom(n)
 * var param_1 = obj.seat()
 * obj.leave(p)
 */
