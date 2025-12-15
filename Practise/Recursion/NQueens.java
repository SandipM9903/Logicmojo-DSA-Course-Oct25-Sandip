package Practise.Recursion;

import java.util.*;

/*
    N-Queens Problem Notes (Recursion + Backtracking)
Goal

Place N queens on an N x N chessboard such that no two queens attack each other.

Step 1: Recursive Queen Placement Function
		void queenPlace(char[][] board, int row, int n, List<List<String>> ans)

		Parameters

		board → current chessboard state

		row → current row where we try to place a queen

		n → size of the board

		ans → stores all valid solutions

		Logic

		Base condition
		If row == n, all queens are placed safely
		→ convert board to List<String>
		→ add to ans
		→ return

		For the current row, try placing a queen in every column

		Before placing, call isSafe

		If safe:

		place 'Q'

		recurse to row + 1

		backtrack by resetting '.'

		Concept Used

		Recursion

		Backtracking

Step 2: Convert Board to Output Format
		private List<String> constructBoard(char[][] board)

		Purpose

		Convert char[][] board into List<String>

		Required because final answer format is List<List<String>>

		Logic

		Each row (char[]) is converted into a String

		Add each string to a list and return

Step 3: Safety Check Function
		boolean isSafe(char[][] board, int row, int col, int n)

		Checks Performed

		Vertical (same column, upward)

		Left diagonal (↖)

		Right diagonal (↗)

		Important Note

		Horizontal check is NOT required

		Reason: Only one queen is placed per row

		Returns

		true → position is safe

		false → position is not safe

Step 4: Main Function
		public List<List<String>> solveNQueens(int n)

		Logic

		Create an empty result list ans

		Initialize n x n board with '.'

		Start recursion from row 0

		Return ans
*/

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
