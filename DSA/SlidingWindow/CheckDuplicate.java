/*
Problem Statement
Given an array 'arr' of 'N' integers and an integer 'K'. The array 'arr' may contain duplicate integers. Return "true" if the array contains any duplicate element within the 'K' distance from each other, otherwise, return "false".
*/

/*
Brute Force
The naive approach is to run two loops, the outer loop will pick each element one by one.

The inner loop compares all elements which are within ‘K’ distance from and with the currently selected element. 

If the selected element matches with any of the elements that we are comparing in the inner loop then it means there is a duplicate.

Time Complexity
O(K*N) per test case, where N is the size of the array and K is distance.

 

In the worst case, for each element in the array (O(N)), we will be checking the subarray of K elements (O(K)). Thus a total of O(N * K) time.   

Space Complexity
O(1)

Constant extra space is use
*/

/*
    Time Complexity: O(K*N).
    Space Complexity: O(1)

    where 'K' represents the window size and 'N' is the size of array.
*/

public class Solution {
    public static boolean checkDuplicate(int[] arr, int n, int k) {

        // Iterating each element.
        for (int i = 0; i < n; i++) {
            
			/*
            	Compares all elements with a selected
				element which are within 'k' distance.
		    */
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (arr[i] == arr[j]) {

					// If equal return true.
                    return true;
                }
            }
        }
        return false;
    }
} 

/*
Using Map
We need to check if the duplicate exists at a distance of ‘K’. 

We can do that by storing the element and its index in a map ‘MP’.
Now iterate over the array, if ‘ARR[i]’ doesn't exist in the map, then add ‘ARR[i]’ and ‘i’ in the map.
If ‘ARR[i]’ exists in the map then:
If ‘i’ - ‘MP['ARR[i]']’ is less than equal to ‘K’, then return true. As the distance of the last occurrence of ‘ARR[i]’  is less ‘K’.
Else update ‘MP[’ARR[i]']' by ‘i’. (Updating last occurrence index of ‘ARR[i]’.
Return false in all other case.
Time Complexity
O(N), where ‘N’ is the length of the array.

 

Since we are iterating over the whole array once, So the overall time complexity will be O(N).

Space Complexity
O(N), where ‘N’ is the length of the array.

 

In the worst case we have to store all elements in the map,So the overall space complexity will be O(N).
*/

/*

	Time Complexity: O(N)
	Space Complexity: O(N)

	Where 'N' is the size of array.

*/

import java.util.HashMap;

public class Solution {
    public static boolean checkDuplicate(int[] arr, int n, int k) {
         HashMap<Integer,Integer> mp = new HashMap<>();

		for(int i = 0; i < n; i++){

            /*
				If 'mp' doesn't contain 'arr[i]'
				the add 'arr[i]' and 'i' in 'mp'.
			*/
            if(mp.containsKey(arr[i]) == false){
                mp.put(arr[i],i);
            }
            
            else{

				/*
					If difference of last occurance of and current
					index is less than equal to 'k' then return true.
				*/
                if(i - mp.get(arr[i]) <= k){
                    return  true;
                }
                
                // Otherwise update key value of 'arr[i]'.
                else{
                    mp.put(arr[i],i);
                }
            }
        }
        return false;
    }

}

/*
Sliding Window Technique
We can use the sliding window technique. The idea is to process every window of size ‘K’ one at a time and store it into Set, now if the element is repeated in a window of size ‘K’ then we can say there is a duplicate within ‘K’ distance.

Initially, our window will contain the first ‘K’ element which is stored in Set.
Then for each remaining element, If it is already in the window return true. Otherwise, add it to the window. While adding the element in the window we have to also remove (i- ‘K’ - 1)th element from the current window i.e our Set.
Time Complexity
O(N) per test case, where N is the size of the array.

 

Since we are only traversing the array once. So overall time complexity will be O(N).

Space Complexity
O(K)

 

Since we are only using the set for storing a window of size ‘K’ only.So the overall space complexity will be O(K). 
*/

/*
    Time Complexity-O(N)
    Space Complexity-O(K)
    where N is the size of array and K is the size of window.
*/

import java.util.HashSet;

public class Solution {

    public static boolean checkDuplicate(int[] arr, int n, int k) {

        // Creating set for storing elements within 'k' range
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < n; i++) {

            /*
            	If the window already contain current element 
				i.e we find duplicate element within the 'k' 
				distance from each other.
			*/

            if (window.contains(arr[i])) {

                return true;
            } 
			
			else {

                // Adding current element to window.
                window.add(arr[i]);
            }

            // For sliding window ,remove the (i-k)th from window.
            if (i >= K) {
                window.remove(arr[i - K]);
            }
        }
        // There is no duplicate element within the 'k' distance from each other.
        return false;
    }
}

