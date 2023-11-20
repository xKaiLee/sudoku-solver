public class SudokuSolver {

    private static int size = 9;

    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        if (solveBoard(board)) {
            System.out.println("I solved it!");
        }
        else {
            System.out.println("I can't solve it");
        }

        for (int row = 0; row < size; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("----------------");
            }
            for (int column = 0; column < size; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }

    }
    private static boolean numberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < size; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean numberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean numberInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean rightPlace(int[][] board, int number, int row, int column) {
        return !numberInRow(board, number, row) &&
                !numberInColumn(board, number, column) &&
                !numberInBox(board, number, row, column);
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (board[row][column] == 0) {
                    for (int numberTry = 1; numberTry <= size; numberTry++) {
                        if (rightPlace(board, numberTry, row, column)) {
                            board[row][column] = numberTry;

                            if (solveBoard(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



}