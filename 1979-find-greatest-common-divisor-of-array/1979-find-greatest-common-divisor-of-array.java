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
        
        if(a == 0)
            return b;
        
        if(b == 0)
            return a;
        
        if(a > b)
            return gcd(a-b , b);
        
        else if(a < b)
            return gcd(a , b-a);
        else 
            return a;
    }
}