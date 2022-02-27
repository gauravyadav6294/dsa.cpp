/*
Problem Statement
You have been given a matrix ‘MAT’ of size 'N' * 'M' (where 'N' and 'M' denote the number of rows and columns respectively) and a positive integer ‘K’. Your task is to rotate the matrix to the right 'K' times.

*/

/*Row-wise rotation
This approach is based on the fact that when we rotate an array to the right by ‘K’ times, it shifts ‘K’ elements from the end to the beginning of the array while the remaining elements shift towards the end. The effective rotations in ‘MAT’ can be from 0 to 'M' - 1, as we get the same matrix ‘MAT’ after every 'M' rotations. So, we will set ‘K’ to ‘K’ % ‘M’.

 

Now, we traverse ‘MAT’ row-wise. We will follow the below steps to rotate the ‘i'-th row of ‘MAT’:

 

First, we reverse all the elements of the row ‘MAT[i]’.
We then reverse the first 'K' elements.
Finally, we reverse the next ‘N’ - 'K' elements.
We will initialize a vector/list ‘result’ and append each row after rotating it.
Finally, we return the ‘result’.
Time Complexity
O(N * M), where ‘N’ and ‘M’ are the number of rows and columns of the given matrix.

 

The time complexity to rotate one row is O(M) and there are total ‘N’ rows. Thus, the overall time complexity will be O(N * M).

Space Complexity
O(1)

 

Since constant space is used, thus the space complexity will be O(1).


*/

/*
    Time Complexity: O(N * M)
    Space Complexity: O(1)

    Where 'N' and 'M' denote the number of rows and columns of the given matrix.
*/

public class Solution {
	public static void rotateRightByK(int temp[], int k) {
		int i = 0, j = temp.length - 1;
		// Reversing the whole array row.
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;
		}
		// Reversing first 'K' elements.
		i = 0;
		j = k - 1;
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;

		}
		i = k;
		j = temp.length - 1;
		// Reversing the rest 'N' - 'K' elements.
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;
		}
	}

	public static int[][] rotateMatRight(int[][] mat, int n, int m, int k) {
		// Array to store the answer matrix sequence.
		int result[][] = new int[n][m];
		int resultIndex = 0;

		// Calculating effective rotations.
		k = k % m;

		// Iterating for each row and appending after rotations to the answer sequence.
		for (int i = 0; i < n; i++) {
			// Calling the function to rotate the row 'K' times.
			rotateRightByK(mat[i], k);

			// Append row 'i' to the answer sequence after rotation.
			result[resultIndex++] = mat[i];
		}
		// Return the answer sequence.
		return result;
	}
}