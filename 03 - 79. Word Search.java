class Solution {
    // Main function to check if the word exists in the board
    public boolean exist(char[][] board, String word) {
        // Iterate through each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first character of the word matches the current cell, start searching
                if (board[i][j] == word.charAt(0) && find(word, board, 0, i, j)) {
                    return true;
                }
            }
        }
        return false; // Word not found in the board
    }

    // Recursive function to search for the word starting from a specific cell
    public boolean find(String word, char[][] board, int index, int row, int col) {
        // If the index reaches the length of the word, all characters have been found
        if (index == word.length()) {
            return true;
        }

        // Check boundary conditions and if the current cell matches the word's character
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the current cell as visited
        char temp = board[row][col];
        board[row][col] = '*';

        // Recursively search in all four directions
        boolean found = find(word, board, index + 1, row + 1, col) || // Down
                        find(word, board, index + 1, row - 1, col) || // Up
                        find(word, board, index + 1, row, col + 1) || // Right
                        find(word, board, index + 1, row, col - 1);   // Left

        // Restore the original value of the current cell
        board[row][col] = temp;
        return found;
    }
}
