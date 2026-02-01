package cp

// https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/?envType=problem-list-v2&envId=wagr6fec
class Solution_3381 {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val pres = LongArray(nums.size)
        pres[0] = nums[0].toLong()
        for (i in 1 until nums.size) {
            pres[i] = pres[i-1] + nums[i].toLong()
        }
        // return withExtraSpace(pres, k)
        return withoutExtraSpace(pres, k)
    }

    fun withoutExtraSpace(pres: LongArray, k: Int): Long {
        var ans = pres[k-1]

        for (i in pres.size-1 downTo k) {
            pres[i] = pres[i]-pres[i-k]
        }

        for (i in 0 until k) {
            val index = k+i-1
            if (index >= pres.size) {
                break
            }

            var currSum = pres[index]
            var maxSum = pres[index]
            for (j in index+k until pres.size step k) {
                currSum += pres[j]
                if (currSum < pres[j]) {
                    currSum = pres[j]
                }
                if (maxSum < currSum) {
                    maxSum = currSum
                }
            }
            if (ans < maxSum) {
                ans = maxSum
            }

        }
        return ans
    }

    fun withExtraSpace(pres: LongArray, k: Int): Long {
        var ans = pres[k-1]

        val arrs = Array(k) { mutableListOf<Long>() }
        arrs[0].add(pres[k-1])
        for (i in k until pres.size) {
            arrs[(i+1)%k].add(pres[i]-pres[i-k])
        }

        for (arr in arrs) {
            if (arr.size == 0) {
                continue
            }
            var currSum = arr[0]
            var maxSum = arr[0]
            for (i in 1 until arr.size) {
                currSum += arr[i]
                if (currSum < arr[i]) {
                    currSum = arr[i]
                }
                if (maxSum < currSum) {
                    maxSum = currSum
                }

            }
            if (maxSum > ans) {
                ans = maxSum
            }
        }

        return ans
    }
}
