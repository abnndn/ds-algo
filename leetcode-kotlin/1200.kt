package cp

// https://leetcode.com/problems/minimum-absolute-difference/?envType=daily-question&envId=2026-01-26
class Solution_1200 {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()

        var minDiff = arr[arr.size-1]-arr[0]
        for (i in 1 until arr.size) {
            if (minDiff > arr[i]-arr[i-1]) {
                minDiff = arr[i]-arr[i-1]
            }
        }

        val ans = mutableListOf<List<Int>>()

        for (i in 1 until arr.size) {
            if (arr[i]-arr[i-1] == minDiff) {
                ans.add(listOf(arr[i-1], arr[i]))
            }
        }

        return ans
    }
}
