/*Problem Statement
You have been given an integer array/list(ARR) of size 'N'. It only contains 0s, 1s and 2s. Write a solution to sort this array/list. */

import java.util.*;

public class Solution{

    public static void sort012(int arr[], int n){
        int low=0;
        int mid=0;
        int high=n-1;

        while(mid<=high){
            if(arr[mid]==0){
              int temp=arr[low];
              arr[mid]=arr[low];
              arr[mid]=temp;
              low++,mid++;
            }

            else if(arr[mid]=1){
               mid++;
            }
            else{
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                mid++, high--;
            }
        }
    }
}