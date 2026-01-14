package cp

//https://leetcode.com/problems/repeated-dna-sequences/description/?envType=problem-list-v2&envId=bit-manipulation
class Solution_187 {
    val mapp = hashMapOf(
        'A' to 0,
        'C' to 1,
        'G' to 2,
        'T' to 3
    )

    val r_mapp = hashMapOf(
        0 to 'A',
        1 to 'C',
        2 to 'G',
        3 to 'T'
    )

    fun decode(number: Int): String {
        var num = number
        var subs: String = ""

        for (i in 9 downTo 0) {
            val curr = num and 3
            subs += r_mapp[curr]!!
            num = num shr 2
        }
        return subs.reversed()
    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length <= 10) {
            return listOf()
        }

        var curr = 0
        val patterns = mutableSetOf<Int>()
        for (i in 0 until 10) {
            curr = (curr shl 2) or mapp[s[i]]!!
        }
        patterns.add(curr)

        val results = mutableSetOf<String>()

        for (i in 10 until s.length) {
            curr = ((curr shl 2) or mapp[s[i]]!!) and ((1 shl 20) - 1)

            if (!patterns.add(curr)) {
                results.add(decode(curr))
            }
        }

        return results.toList()
    }
}
