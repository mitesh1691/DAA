import java.util.Scanner;

public class NQueensBranchAndBound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (N): ");
        int N = scanner.nextInt();
        scanner.close();

        int[][] board = new int[N][N];
        System.out.println("Step-by-step process of placing queens:\n");

        if (solveNQueens(board, 0, N)) {
            System.out.println("\nFinal solution:");
            printSolution(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    static boolean solveNQueens(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }

        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1;
                System.out.println("Placing queen at row " + (row + 1) + ", column " + (col + 1) + "\n");
                printBoard(board);
                if (solveNQueens(board, col + 1, N)) {
                    return true;
                }
                System.out.println("Backtracking at row " + (row + 1) + ", column " + (col + 1) + "\n");
                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static void printSolution(int[][] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printBoard(int[][] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
