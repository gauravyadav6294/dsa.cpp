import java.util.*;
import java.io.*;

public class Main{

    public static int kadanes(int arr[]){
        int csum=arr[0];
        int msum=arr[0];

        for(int i-0;i<arr.length;i++){
            if(csum>=0){
                csum+=arr[i];
            }
            else{
                csum=arr[i];
            }

            if(csum>msum){
                msum=csum;
            }
        }
        return msum;
    }

    public static int kadanesoftwo(int arr[]){
        int [] narr= new int[arr.length*2];
        for(int i=0;i<arr.length;i++){
           narr[i]=arr[i];
        }

        for(int i=0;i<arr.length;i++){
            narr[i+arr.length]=arr[i];
        }

        return kadanes(narr);
    }

    public static long solution(int arr[], int k, long sum){
        if(k==1){
        return kadanes(arr);
        }
        else if(sum<0){
            return kadanesoftwo(arr);
        }
        else{
          return kadanesoftwo(arr)+(k-2)*sum;
        }
    }
}