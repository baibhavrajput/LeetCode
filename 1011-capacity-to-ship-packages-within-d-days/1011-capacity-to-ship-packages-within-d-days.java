class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0 ; i<n ; i++){
            maxi = Math.max(maxi , weights[i]);
            sum = sum + weights[i];
        }
        
        int left = maxi;
        int right = sum;
        int res = 0;
        
        while(left <= right){
            
            int mid = left + (right-left)/2;
            
            if(isPossible(weights , mid , days , n)){
                res = mid;
                right = mid - 1;
            }
            
            else
                left = mid + 1;
        }
        return res;
    }
    
    private boolean isPossible(int[] arr , int mid , int days , int n){
        
        int count = 1;
        int sum = 0;
        
        for(int i=0 ; i<n ; i++)
        {
            sum = sum + arr[i];
            
            if(sum > mid){
                count++;
                sum = arr[i];
            }  
        }
        return (count <= days);
    }
}