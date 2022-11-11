class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        long sum = 0;
        
        for(int i=0 ; i<n ; i++){
            sum = sum + nums[i];
        }
        
        long firstSum = 0;
        long mini = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i=0 ; i<n ; i++){
            
            firstSum = firstSum + nums[i];
            
            sum = sum - nums[i];
            
            long diff ;
            
            if(i == n-1){
                diff = firstSum/n;
            }
            else{
                diff = Math.abs((firstSum/(i+1)) - (sum/(n-(i+1))));
            }
            
            if(diff < mini){
                mini = diff;
                res = i;
            }
        }
        return res;
    }
}