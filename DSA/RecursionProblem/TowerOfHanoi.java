/*
Problem Statement
You are given three rods (numbered 1 to 3), and ‘N’ disks initially placed on the first rod, one on top of each other in increasing order of size ( the largest disk is at the bottom). You are supposed to move the ‘N’ disks to another rod(either rod 2 or rod 3) using the following rules and in less than 2 ^ (N) moves.
1. You can only move one disk in one move. 
2. You can not place a larger disk on top of a smaller disk.
3. You can only move the disk at the top of any rod.  
*/

/*
Recursive Approach
The idea is to use recursion to solve the problem. Firstly, we will try to solve this problem for N = 2; we can move a disk from rod 1 to rod 2, then move another disk from rod 1 to rod 2, and then move the disk in rod 2 to rod 3, this way we can move all the disks to rod 3. Now, to solve for N = 3, we can first solve the problem for the first two disks and then move the last disk to another rod and then place the two disks on top of the last disk. 

 

Generalizing this approach, to solve the problem for ‘N’ disks we will first solve the problem for ‘N-1’ disks and then move the last disk to another rod, thus completely solving the problem for ‘N’ disks.

 

The steps are as follows :

Let’s define a recursive function as moveDisk(n, toRod, fromRod, moves). Here, ‘n’ denotes the number of disks we are solving the problem for, “toRod” denotes the number of the rod to which we will move the disk to, “fromRod” denotes the number of the rod from where we will remove the disk and “moves” is a 2-D array for storing the moves that we will perform.
If the value of ‘n’ is 1 then simply move the only disk from “fromRod” to “toRod” and add the values of “to” and “from” in the moves array.
Otherwise, find the number of the remaining rod (rod other than “toRod” and “fromRod”), let’s say this rod is “rem”. Now recursively move the top ‘n - 1’ disks from “fromRod” to “rem” rod by calling moveDisk(n - 1, rem, fromRod, moves).
Now we have removed the top ‘n - 1’ disks from “fromRod” and placed them on ”rem” rod; hence we will move the last disk (n’th disk) of the “fromRod” to the “toRod” and add the values of “toRod” and “fromRod” in the answer.
After this, we need to move the remaining n - 1 disks from the “rem” rod to “toRod”, thus we will again recursively call the function, moveDisk(n - 1, ”toRod”, “rem”, moves).
Now we have moved all the ‘N’ disks to another rod; hence we will return the moves array.
Time Complexity
O(2 ^ N), where N is the number of disks.

 

We need exactly 2 ^ N -1 moves to shift N disks from one rod to another. Hence, the overall Time Complexity is O(2 ^ N).

Space Complexity
O(N), where N is the number of disks.

 

We are using recursion to move disks and the maximum size of the recursion stack is N. Hence, the overall Space Complexity is O(N).
*/

/*
    Time Complexity: O(2 ^ N)
    Space Complexity: O(N)

    Where 'N' is the number of disks.
*/

import java.util.ArrayList;

public class Solution 
{
    private static void moveDisks(int n, int toRod, int fromRod, ArrayList < ArrayList<Integer>> moves) 
    {
        
        //    If there is only one disk move that disk
        if (n == 1) 
        {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(fromRod);
            ans.add(toRod);
            moves.add(ans);
            return;
        }

        //    Value of rem rod can be calculated by simply xoring number of each rod and toRod and fromRod.
        int rem = 1 ^ 2 ^ 3 ^ toRod ^ fromRod;

        //    Move the top n-1 to the rem rod.
        moveDisks(n - 1, rem, fromRod, moves);

        //    Move the n'th disk to toRod.
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(fromRod);
        ans.add(toRod);
        moves.add(ans);

        //    Move the n-1 disks from rem rod to toRod.
        moveDisks(n - 1, toRod, rem, moves);
    }

    public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n) 
    {
        //    For storing the moves.
        ArrayList < ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();

        moveDisks(n, 2, 1, moves);

        //    Return the stored moves.
        return moves;
    }
}