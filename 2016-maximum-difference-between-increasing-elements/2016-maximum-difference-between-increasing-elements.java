class Solution {
    public int maximumDifference(int[] nums) {
        
        int n = nums.length;
        
        int smaller = nums[0];
        int maxi = 0;
        
        for(int i=1 ; i<n ; i++){
            
            smaller = Math.min(smaller , nums[i]);
            maxi = Math.max(maxi , nums[i]-smaller);
        }
        
        return maxi==0 ? -1 : maxi;
    }
}