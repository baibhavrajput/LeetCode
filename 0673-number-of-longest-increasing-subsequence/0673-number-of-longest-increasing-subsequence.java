class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        
        int[] count = new int[n];
        Arrays.fill(count , 1);
        
        int maxi = 1;
        
        for(int ind=0 ; ind<n ; ind++){
            for(int prev = 0 ; prev<ind ; prev++){
                
                if(nums[ind] > nums[prev]){
                    if(dp[prev] + 1 > dp[ind]){
                        dp[ind] = dp[prev]+1;
                        count[ind] = count[prev];
                    }
                    else if(dp[prev] +1 == dp[ind])
                        count[ind] = count[ind] + count[prev];
                }
            }
            maxi = Math.max(maxi , dp[ind]);
        }
        
        int cnt = 0;
        for(int i=0 ; i<n ; i++){
            if(dp[i] == maxi)
                cnt = cnt + count[i];
        }
        return cnt;
    }
}