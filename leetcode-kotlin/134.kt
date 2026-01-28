package cp

// https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
class Solution_134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        var total_gas = 0

        for (i in 0 until gas.size) {
            total_gas += gas[i]-cost[i]
        }
        if (total_gas < 0) {
            return -1
        }

        var pot_index = gas.size-1
        var bg_sp = 0      // biggest surplus
        var curr_sp = 0    // curr surplus

        var index = gas.size-1
        for (index in gas.size-1 downTo 0) {
            curr_sp += gas[index]-cost[index]

            if (curr_sp >= bg_sp) {
                pot_index = index
                bg_sp = curr_sp
            }
        }

        return pot_index
    }
}

// Example 1
//gas -     1 2 3  4  5
//gasSum -  1 3 6  10 15
// index -  0 1 2  3  4
//cost -    3 4 5  1  2
//costSum - 3 7 12 13 15

// Example 2
// gas     - 2 3 4
// gasSum  - 2 5 9
// index   - 0 1 2
// cost    - 3 4 3
// costSum - 3 7 10
