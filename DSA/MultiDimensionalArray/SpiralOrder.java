/*

Problem Statement
You are given a 2-D array 'MATRIX' of dimensions N x M, of integers. You need to return the spiral path of the matrix.
Example Of Spiral Path:
*/

/*
Spiral Path - Iteratively
The idea is to traverse the matrix using for loops where each loop will be used for a specific direction to print all the elements in the clockwise order layer by layer. Every ‘for’ loop traverses the matrix in a single direction. The first loop traverses the matrix from left to right, the second loop traverses the matrix from top to bottom, the third traverses the matrix from the right to left, and the fourth traverses the matrix from bottom to up. After completing the traversal using 4 loops one time repeat it(4 for loops) again for the remaining submatrix. To traverse using these loops we will initialize 4 variables to keep the boundaries of the submatrix as explained below.

 

Algorithm:

spiralPrint(matrix[][], rows, cols):

Initialize two variables ‘R’, ‘C’ with 0 to denote the lowest boundary for row and column of the submatrix remaining. Also, rows and cols denote the maximum boundary for the submatrix remaining.
While(R < rows and C < cols) :
Print the first row from left to right of the remaining submatrix i.e from column ‘C’ to ‘cols’, print the elements of the Rth row. Increment ‘R’ by 1.
Print the last column from top to bottom of the remaining submatrix i.e from row ‘R’ to ‘rows’, print the elements of the (cols)th column. Decrement ‘cols’ by 1.
Print the last row from right to left of the remaining submatrix i.e from column ‘cols’ to ‘C’, print the elements of the (rows)th row. Decrement ‘rows’ by 1.
Print the first column from bottom to top of the remaining submatrix i.e from row ‘rows’ to ‘R’, print the elements of the Cth column. Increment ‘C’ by 1.
Time Complexity
O(N * M), where ‘N’ is the number of rows and ‘M’ is the number of columns of the matrix.

 

We are traversing the entire matrix of N * M elements. Thus, the overall complexity is O(N * M).

Space Complexity
O(1).

 

In the worst case, only a constant extra space is required.
*/

/*
    Time Complexity : O(N * M)
    Space Complexity : O(1)

    Where N is the number of rows in the matrix,
    and M is the number of columns in the matrix.
*/

/*
    Time Complexity : O(N * M)
    Space Complexity : O(1)

    Where N is the number of rows in the matrix,
    and M is the number of columns in the matrix.
*/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Integer> spiralPathMatrix(int[][] matrix, int n, int m) {

        int i;
        int r = 0;
		int rows = n;
        int c = 0;
		int cols = m;
     
        /*  
            r - starting row index,
            rows - ending row index,
            c - starting column index,
            cols - ending column index,
            i - iterator.
        */
     
        // Make vector to store the path.
        List<Integer> path = new ArrayList();

        while (r < rows && c < cols) {
            // Push the first row from the remaining rows.
            for (i = c; i < cols; ++i) {
                path.add(matrix[r][i]);
            }
            r = r + 1;
     
            // Push the last column from the remaining columns.
            for (i = r; i < rows; ++i) {
                path.add(matrix[i][cols - 1]);
            }
            cols = cols - 1;
     
            // Push the last row from the remaining rows.
            if (r < rows) {
                for (i = cols - 1; i >= c; --i) {
                    path.add(matrix[rows - 1][i]);
                }
                rows = rows - 1;
            }
     
            // Push the first column from the remaining columns. 
            if (c < cols) {
                for (i = rows - 1; i >= r; --i) {
                    path.add(matrix[i][c]);
                }
                c = c + 1;
            }
        }

        return path;

    }
}
