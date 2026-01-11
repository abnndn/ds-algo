// Entry point
package cp

fun main() {
    val solution = Solution()

    // Test Case 1
    val banned1 = intArrayOf(1, 6, 5)
    val n1 = 5
    val maxSum1 = 6
    println("Test Case 1 Result: " + solution.maxCount(banned1, n1, maxSum1))
    // Expected output logic: 1, 2, 3, 4, 5. Banned: 1, 5, 6. Available: 2, 3, 4.
    // Sum: 2+3=5 (OK), +4=9 (Exceeds 6). Count = 2.

    // Test Case 2
    val banned2 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val n2 = 8
    val maxSum2 = 1
    println("Test Case 2 Result: " + solution.maxCount(banned2, n2, maxSum2))
}
