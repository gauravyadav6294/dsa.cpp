/*
Problem Statement
Given an array “A” of N integers and you have also defined the new array “B” as a concatenation of array “A” for an infinite number of times.
For example, if the given array “A” is [1,2,3] then, infinite array “B” is [1,2,3,1,2,3,1,2,3,.......].
Now you are given Q queries, each query consists of two integers “L“ and “R”. Your task is to find the sum of the subarray from index “L” to “R” (both inclusive) in the infinite array “B” for each quer
*/


/*
  Brute Force
Instead of creating a new infinite array B which has a repeated array A elements in the form [A1, A2,... AN, A1, A2,... AN, A1, A2,... AN…....]. We will traverse array A, again and again, to find the sum as array A is only repeating in infinite array B.
So the brute force approach is, for each query,
we run a loop from L to R, and for each index i, add the value at index (i%N) of the array A i.e A[i%N] to sum. So this way we can find the sum of the required subarray from index L to R in an infinite array B.
Time Complexity
O(Q*(R-L)) per test case, where Q is the number of given queries, and L and R are the given two indexes in each query.
 

In the worst case, for each query O(Q), we will be running a loop from L to R that takes (O(R-L)) time. Thus a total of O(Q*(R-L)) time will be required.

Space Complexity
O(1)
 

In the worst case, only a constant space is required.
*/

import java.util.List;
import java.util.ArrayList;

public class Solution {

    private static int mod = (int) 1e9 + 7;

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        // It stores answer for each query.
        List<Integer> ans = new ArrayList<>();

        // Traversing the given queries
        for (List<Long> range : queries) {

            // Substract 1 from both L and R to use it as 0-based indexing
            long l = range.get(0) - 1;
            long r = range.get(1) - 1;

            // It stores the sum
            long sum = 0;

            for (long i = l; i <= r; i++) {
                int index = (int) (i % n);
                sum = (sum + arr[index]) % mod;
            }
            sum %= mod;
            // Add answer to each query
            ans.add((int) sum);
        }

        return ans;

    }
}

/*
Prefix Sum Array
The better idea is to first create the sum array in which sumArray[i] stores the sum from (A[0]+....+A[i]). Now instead of iterating from L to R like in the previous approach, we find the sum using our sumArray[].

Let’s take an example, where array A = [1,2,3] and we have to find the sum of the subarray of the infinite array(as shown in below fig) from index 3 to 10 (0-based indexing). 

Now instead of iterating from 3 to 10 and then calculate the sum. We can observe one thing that we are going to traverse the array A again and again so instead of doing this, we can first find the sum from index 0 to index 10 say a, and then find the sum from index 0 to 2 say b, then subtract b from a as a-b, which is the sum of subarray from index 3  to 10 in an infinite array B.
Now to find the sum, from index 0 to any index X, we first find how many number of times the given array A can comes completely upto index X. which can be simply found by X / N say count , and sum will be count * sumArray[N] where N is the length of array A. Now for the remaining part of the subarray sum can be found by sumArray[ (X % N)]. 
Consider array A = {1, 2, 3} and we have to find the sum between L= 1 and R = 5. Then Till index 5 the array A repeats itself one time i.e {1, 2, 3, 1, 2} which can be calculated as R/N i.e 1 and the remaining elements till index 5 are {1, 2} which can be calculated as R%N. So the sum till index 5 is R/N * sumArray(N) + sumArray(R%N).
So this way we can find the sum without iterating from L to R.

Time Complexity
O(Q+N) per test case, where N is the size of the given array, and Q is the number of queries given
 

In the worst case, we will only traverse the given array, O(N) only one time, and for each query (O(Q)), we will be calculating the sum in constant time. Thus a total of O(N+Q) time will be required.   

Space Complexity
O(N), where ‘N’ is the size of the given array.
 

In the worst case, we will be storing the prefix sums in an array, of size N, Thus a total of O(N) space will be required.
*/


/*
    Time Complexity:O(Q+N).
    Space Complexity:O(N).
    Where N is the size of the given array, and Q is the number of queries given.

*/

import java.util.List;

import java.util.ArrayList;

public class Solution {

    private static int mod = (int) 1e9 + 7;

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        // It stores answer for each query.
        List<Integer> ans = new ArrayList<>();

        // It store cumulative sum where sumArray[i] = sum(A[0]+..A[i]).
        long sumArray[] = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            sumArray[i] = (sumArray[i - 1] + arr[i - 1]) % mod;
        }

        // Traversing the given queries.
        for (List<Long> range : queries) {

            long l = range.get(0);
            long r = range.get(1);

            // It stores the prefix sum from index 0 to index r in an infinite array.
            long rsum = func(sumArray, r, n);

            // It stores the prefix sum from index 0 to index l-1 in an infinite array.
            long lsum = func(sumArray, l - 1, n);

            // Add answer for each query.
            ans.add((int) ((rsum - lsum + mod) % mod));

        }

        return ans;
    }

    // Function to calculate prefix sum upto index x of the infite array.
    private static long func(long sumArray[], long x, long n) {

        // Number of times the given array comes completely upto index x.
        long count = (x / n) % mod;

        long res = (count * sumArray[(int) n]) % mod;

        // Adding the remaining elements sum.
        res = (res + sumArray[(int) (x % n)]) % mod;

        return res;
    }
}