/*Problem Statement
You are given an array (ARR) of length N, consisting of integers. You have to find the sum of the subarray (including empty subarray) having maximum sum among all subarrays.
A subarray is a contiguous segment of an array. In other words, a subarray can be formed by removing 0 or more integers from the beginning, and 0 or more integers from the end of an array.
*/

/*
Sum Array Approach-(kadane algorithum).
Let us start from the left of the array. We maintain an array curSum[], which keeps track of the maximum sum of the subarray ending at the index we’re at. 

While traversing the array, If the value of curSum[i] becomes negative, we can simply discard this part of the array because it has a negative contribution to the subarray sum. It would be better to just drop that part and have a zero contribution rather than a negative one. Then, we can start anew with the next element. In other words, curSum[i] can be reset to 0.

The maximum value in the curSum array will be our answer.

Time Complexity
O(N), where N is the length of the array.

 

Traversing the array once takes O(N) time.

Space Complexity
O(N), where N is the length of the array.

 

Maintaining the curSum array takes O(N) space.


*/

import java.util.*;

public class Solution{
    public static long maxSubarraySum(int arr[], int n){

        long long currSum[n];
        long long maxSum=0;

        for(int i=0;i<n;i++){
            if(i==0){
                currSum[i]=max(0,arr[i]);
            }
            else{
                currSum[i]=max(011,currSum[i-1]+arr[i]);
            }

            maxSum=max(maxSum,currSum[i]);
        }
        return maxSum;
    }
}