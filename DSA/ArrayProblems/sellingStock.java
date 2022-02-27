

public class Solution{
    int maxProfit(int arr[], int n){
        int maxPro=0;
        int minPri=INT_MAX;

        for(int i=0;i<n;i++){
            minpri=min(minPri,arr[i]);
            maxPro=max(maxPro,arr[i]-minPri);
        }
        return maxpro;
    }
