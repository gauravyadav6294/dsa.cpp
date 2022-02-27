/*

Problem Statement
Aahad and Harshit always have fun by solving problems. Harshit took a sorted array and rotated it clockwise by an unknown amount. For example, he took a sorted array = [1, 2, 3, 4, 5] and if he rotates it by 2, then the array becomes: [4, 5, 1, 2, 3].
After rotating a sorted array, Aahad needs to answer Q queries asked by Harshit, each of them is described by one integer Q[i]. which Harshit wanted him to search in the array. For each query, if he found it, he had to shout the index of the number, otherwise, he had to shout -1.
For each query, you have to complete the given method where 'key' denotes Q[i]. If the key exists in the array, return the index of the 'key', otherwise, return -1.
*/

/*
Brute Force Approach
The idea here is to do a linear approach which apparently is a brute force way to do this.

Visit every element one by one.
Check if the current element that you are looking at is the key value that needs to be searched. If the element is found, return the index at which you find it.
Once all the elements are visited and you don't find the key-value, return -1.
Time Complexity
O(N), where N is the total number of elements in the array.

 

In the worst case, we have to visit every element. Hence the overall time complexity is O(N).

Space Complexity
O(1)

 

Since a constant amount of space is used. Hence the overall space complexity is O(1).
*/

public class Solution{
    public static int search(int arr[],int key){
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}


/*
Binary Search Approach
Before we discuss the algorithm, there's an interesting property about sorted and rotated arrays that must be noted. 

 

If we divide the array into two halves, at least one of the two halves will always be sorted.

 

Let's consider the array: [5, 6, 7, 1, 2, 3, 4]

5	6	7	1	2	3	4
 

Mid-index is calculated as (startIndex + endIndex) / 2 or start + (endIndex - startIndex) / 2.

 

The mid-index for the above-depicted list/array will be 3.

 

The value at the mid-index is 1. If we have a closer look at three values, that are, value at start, end, and mid then we can deduce which the subarray is sorted or not.

 

Since the value at the mid-index is less than the value at the start index, we clearly can say that the left subarray is not sorted or violates the property of a sorted array. 

 

Similarly, we can deduce if the right subarray is sorted or not by comparing the values at mi-index and end index.

 

Now, once we know what part of the array is sorted, we can compare the value(key) to be searched in reference to the sorted subarray.

 

Finally, to put everything in points:

Find the mid index.
If the value(key) being searched for is at the mid index, then return the mid index.
Compare values at start index, end index, and mid-index:
If the left subarray is sorted, check if the value(key) to be searched lies in the range:
If it does, then search space reduces between [start, (mid-1)].
Otherwise, the search space reduces between [(mid + 1), end]
If the right subarray is sorted, check if the value(key) to be searched lies in the range:
If it does, then search space reduces between [(mid + 1), end].
Otherwise, the search space reduces between [start, (mid -1)]
Repeat from step-1 until the key is found.
Return -1 if never found.
Time Complexity
O(log(N)), Where N is the total number of elements in the array.

 

Every time we split the array into halves. Hence the overall time complexity is O(log(N)).

Space Complexity
O(1)

 

Since we are using constant space. Hence the overall space complexity is O(1).


*/
/*
    Time complexity : O(log(N))
    Space complextiy : O(1)

    where N is the size of the input array
 */

public class Solution {

    public static int search(int arr[], int key) {
 
 		// Initialize start and end
        int st = 0, end = arr.length - 1;

        // Performing binary search
        while (st <= end) {
        	
        	// Get the middle element
            int mid = st + (end - st) / 2;

            // The middle element is the one we are searching for
            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] >= arr[st]) {
            	
            	// Element lies towards left of mid
                if (arr[st] <= key && key <= arr[mid]) {
                    end = mid - 1;
                }
                
                // Element lies towards right of mid     
                else {
                    st = mid + 1;
                }
            } 
            else {
            	
            	// Element lies towards right of mid
                if (arr[end] >= key && key >= arr[mid]) {
                    st = mid + 1;
                } 
                
                // Element lies towards left of mid
                else {
                    end = mid - 1;
                }
            }
        }

        // Element not found
        return -1;
    }
}