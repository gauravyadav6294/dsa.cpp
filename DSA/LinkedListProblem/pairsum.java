/*
 1. Brute Force-
 T.C-O(N*N).
 S.C-O(N)
*/
import java.util.*;

public class Solution{
    public static int[][] pairsum(int arr[], int s){
        int n=arr.length;

   // used to store results.
  List<int[]> ans=new Arraylist();

     // checking sum of every element.
     for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
           if(arr[i]+arr[j]==s){
           int pair[]=new int [2];
           pair[0]=arr[i];
           pair[1]=arr[j];
           ans.add(pair); 
           }
         }
     }

     // used to store final sorted result.
     
     int res[][]=new int[ans.size()[2]];
     for(int i=0;i,ans.size();i++){
         int a=ans.get(i)[0], b=ans.get(i)[1];
         res[i][0]=Math.min(a,b);
         res[i][1]=Math.min(a,b);
     }

     Array.sort(res, new comparator<int[]>(){
         public int compare(int a[], int b[]){
             if(a[0]==b[0]){
                 return a[1]-b[1];
             }
             return a[0]-b[0];
         }
     });
     return res;
    }
}

/*
using -hashmap
t.c-O(N*N).
s.c-O(N).
*/

import java.util.*;

public class Solution{
    public static int[][] pairsum(int arr[], int s){
        int n=arr.length;

     // hashmap to store frequency of element.
    Hashmap<Integer,Integer> map=new Hashmap();

    List<Integer> ans=new Arraylist();

    for(int ele:arr){
        int count=map.getorDefault(s-ele,0);
    }
    }
}