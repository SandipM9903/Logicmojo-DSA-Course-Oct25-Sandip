package Practise.Recursion;

import java.util.Arrays;

public class NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        //Initialize the board with "."
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        queenPlace(board, 0, n);
        return count;
    }

    private boolean isSafe(char[][] board, int row, int col, int n){
        //Horizontal
        for(int i=0; i<n; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        //Vertical
        for(int i=0; i<n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //Left-Diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Right-Diagonal
        for(int i=row, j=col; i>=0 && j<0; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
    void queenPlace(char[][] board, int row, int n){
        if(row == n){
            count++;
            return;
        }

        for(int i=0; i<n; i++){
            if(isSafe(board, row, i, n)){
                board[row][i] = 'Q';
                queenPlace(board, row+1, n);
                board[row][i] = '.';
            }
        }
    }
}
