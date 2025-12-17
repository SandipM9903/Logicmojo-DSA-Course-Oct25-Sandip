package Practise.Recursion;

/*
This is the grid drawing.
	0 1 2 3 4 5 6
0	S . . . . . .
1	. . . . . . .
2	. . . . . . R
*/

public class UniquePathDP {
    public int uniquePath(int m, int n){
        int[][] grid = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        //To find the value present in last grid.
        return grid[m-1][n-1];
    }
}
