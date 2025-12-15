package Practise.Recursion;

import java.util.*;

public class NQueens {
     public void queenPlace(char[][] board, int row, int n, List<List<String>> ans){
        if(row == n){
            ans.add(constructBoard(board));
            return;
        }
        //try placing queen in each column
        for(int i=0; i<n; i++){
            if(isSafe(board, row, i, n)){
                board[row][i] = 'Q';
                queenPlace(board, row+1, n, ans);
                board[row][i] = '.';
            }
        }
    }
    //convert char board to List<String>
    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    //Check if the queens are safely placed or not
    public boolean isSafe(char[][] board, int row, int col, int n){
         //Horizontal
        for(int i=0; i<n; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        //Vertical
        for(int j=0; j<n; j++){
            if(board[j][col] == 'Q'){
                return false;
            }
        }
        //left diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //right diagonal
        for(int i=row, j=col; i>=0 && j<n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        //initialize board with "."
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        queenPlace(board, 0, n, ans);
        return ans;
    }
}
