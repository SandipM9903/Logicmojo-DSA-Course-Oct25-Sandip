package Practise.Recursion;

public class SudokuSolver {
    //Third we need to implement isSafe()
    public boolean isSafe(char[][] board, int row, int col, int digit){
        //Horizontal
        for(int i=0; i<9; i++){
            if(board[row][i] == digit){
                return false;
            }
        }

        //Vertical
        for(int i=0; i<9; i++){
            if(board[i][col] == digit){
                return false;
            }
        }

        //grid
        int srow = (row/3) * 3;
        int scol = (col/3) * 3;

        for(int i=srow; i<=srow+2; i++){
            for(int j=scol; j<=scol+2; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(char[][] board, int row, int col){

        //Fourth we need to check the base condition
        if(row == 9){
            return true;
        }

        //First we need to check whether any digit is present in the board[row][col]
        int nextRow = row, nextCol = col+1;
        if(nextCol == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if(board[row][col] != '.'){
            return helper(board, nextRow, nextCol);
        }

        //Second we need to place the digit
        for(char i='1'; i<='9'; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(helper(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}
