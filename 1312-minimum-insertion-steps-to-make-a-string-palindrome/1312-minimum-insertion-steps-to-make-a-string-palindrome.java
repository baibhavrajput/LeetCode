class Solution {
    public int minInsertions(String s) {
        
        int n = s.length();
        Integer[][] dp = new Integer[n+1][n+1];
        int lps = helper(0 , n-1 , s , n , dp);
        
        return n - lps;
    }
    
    public int helper(int i , int j , String s , int n , Integer[][] dp){
        
        
        if(i >= n || j < 0)
            return 0;
        
        if(dp[i][j] != null)
            return dp[i][j];
        
        int pick = 0;
        int notPick = 0;
        
        if(s.charAt(i) == s.charAt(j)){
            pick = 1 + helper(i+1 , j-1 , s , n , dp);
            return dp[i][j] = pick;
        }
        else{
            notPick = Math.max(helper(i+1 , j , s , n , dp) , 
                               helper(i , j-1 , s , n , dp));
            
            return dp[i][j] = notPick;
        }
    }
}