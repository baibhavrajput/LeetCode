class Solution {
    public int findGCD(int[] nums) {
        
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0 ; i<n ; i++){
            mini = Math.min(mini , nums[i]);
            maxi = Math.max(maxi , nums[i]);
        }
        
        return gcd(mini , maxi);
    }
    
    public int gcd(int a , int b){
        
        if(b == 0)
            return a;
        
        return gcd(b , a % b);
    }
}