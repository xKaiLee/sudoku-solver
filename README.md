# Sudoku Solver
This Java program implements a simple Sudoku solver using a backtracking algorithm. 
The solver attempts to fill in a Sudoku board based on the rules of Sudoku, and it prints the solved or unsolved board.
# Sudoku Solving Algorithm
The program uses a backtracking algorithm to fill in the Sudoku board. The solveBoard method iterates through each cell, attempting to place a number from 1 to 9. 
If the placement is valid, it recursively continues to the next cell.If no valid number is found, it backtracks and tries a different number,
repeating until the board is solved or determined to be unsolvable.
