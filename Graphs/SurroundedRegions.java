package Graphs;

public class SurroundedRegions {

    private static int row, col;

    public static void solve(char[][] board) {

        row = board.length;
        col = board[0].length;

        // Check the board boundaries for 'O' and capture them (O -> T)
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O')
                capture(board, r, 0);
            if (board[r][col - 1] == 'O')
                capture(board, r, col - 1);
        }

        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O')
                capture(board, 0, c);
            if (board[row - 1][c] == 'O')
                capture(board, row - 1, c);
        }

        // Once changed all boundary 'O' -> 'T', change all remaining 'O' -> X and
        // change 'T' -> 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }

    }

    private static void capture(char[][] board, int r, int c) {

        // Check if the rows and columns are withing board boundaries and the value on
        // the edges of the board is 'O'
        if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] != 'O')
            return;

        // Change 'O' -> 'T'
        board[r][c] = 'T';
        // Run DFS for all 4 directions
        capture(board, r, c + 1);
        capture(board, r, c - 1);
        capture(board, r + 1, c);
        capture(board, r - 1, c);
    }

    public static void main(String[] args) {

        char[][] board = new char[][] {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };

        solve(board);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
