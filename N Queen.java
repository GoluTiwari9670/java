import java.util.*;

public class NQueen {
    static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        List<List<String>> solutions = new ArrayList<>();
        solve(0, board, solutions, new boolean[n], new boolean[2 * n], new boolean[2 * n]);

        // Print solutions
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    static void solve(int row, char[][] board, List<List<String>> res, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        int n = board.length;
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board)
                solution.add(new String(r));
            res.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row - col + n] || diag2[row + col]) continue;

            board[row][col] = 'Q';
            cols[col] = diag1[row - col + n] = diag2[row + col] = true;

            solve(row + 1, board, res, cols, diag1, diag2);

            // Backtrack
            board[row][col] = '.';
            cols[col] = diag1[row - col + n] = diag2[row + col] = false;
        }
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
