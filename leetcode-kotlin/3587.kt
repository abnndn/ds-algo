package cp

import kotlin.math.abs

// https://leetcode.com/problems/minimum-adjacent-swaps-to-alternate-parity/?envType=problem-list-v2&envId=wagr6fec
class Solution_3587 {
    fun minSwaps(nums: IntArray): Int {
        var odds = 0
        var evens = 0

        for (num in nums) {
            if (num%2 == 0) {
                evens++
            } else {
                odds++
            }
        }

        if (nums.size%2 == 0 && abs(evens-odds) != 0) {
            return -1
        }
        if (nums.size%2 != 0 && abs(evens-odds) != 1) {
            return -1
        }

        if (nums.size%2 == 0) {
            return minOf(
                calculator(true, nums, 0, evens),
                calculator(false, nums, 0, evens)
            )
        }

        if (evens > odds) {
            return calculator(false, nums, 1, odds)
        } else {
            return calculator(true, nums, 1, evens)
        }
    }

    fun calculator(even: Boolean, nums: IntArray, start: Int, size: Int): Int {
        val index = Array(size) { IntArray(2) }

        var currI = 0
        var tar = start
        for (i in 0 until nums.size) {
            if((even && nums[i]%2 == 0) || (!even && nums[i]%2 != 0)) {
                index[currI][0] = i
                index[currI][1] = tar

                currI += 1
                tar += 2
            }
        }

        // print("$even, $start, $size\n")
        // for (i in 0 until index.size) {
        //     print("{${index[i][0]}, ${index[i][1]}}; ")
        // }
        // print("\n")

        var steps = 0
        for (move in index) {
            steps += abs(move[0]-move[1])
        }

        return steps
    }
}
