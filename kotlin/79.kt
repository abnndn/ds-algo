package cp

// https://leetcode.com/problems/word-search/description/
class Solution_79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size

        // 1. Frequency Pruning: Check if the board has enough characters
        val boardFreq = IntArray(128)
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                boardFreq[board[r][c].code]++
            }
        }

        for (char in word) {
            if (--boardFreq[char.code] < 0) return false
        }

        // 2. Rarity Pruning: Start from the rarer end of the word
        val firstCharCount = boardFreq[word[0].code] + 1 // Re-adjusting frequency
        val lastCharCount = boardFreq[word.last().code] + 1

        val optimizedWord = if (lastCharCount < firstCharCount) {
            word.reversed()
        } else {
            word
        }

        val visit = Array(rows) { BooleanArray(cols) }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (recur(board, optimizedWord, visit, 0, i, j)) {
                    return true
                }
            }
        }
        return false
    }

    fun recur(board: Array<CharArray>,
              word: String,
              visit: Array<BooleanArray>,
              index: Int,
              first: Int,
              second: Int): Boolean {
        if (index == word.length) {
            return true
        }
        if (first < 0 || first>=board.size || second<0 || second>=board[0].size) {
            return false
        }
        if (visit[first][second]) {
            return false
        }

        if (board[first][second] != word[index]) {
            return false
        }

        visit[first][second] = true
        if (recur(board, word, visit, index+1, first+1, second) ||
            recur(board, word, visit, index+1, first-1, second) ||
            recur(board, word, visit, index+1, first, second+1) ||
            recur(board, word, visit, index+1, first, second-1)) {
            return true
        }
        visit[first][second] = false
        return false
    }
}
