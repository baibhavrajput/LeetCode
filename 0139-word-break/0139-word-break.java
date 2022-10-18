class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        Boolean[][] dp = new Boolean[n+1][n+1];
        
        return helper(0 , n-1 , s , wordDict , dp);
        
    }
    
    public boolean helper(int i , int j , String s , List<String> wordDict ,
                          Boolean[][] dp)
    {    
        if(i > j)
            return false;
        
        if(wordDict.contains(s.substring(i,j+1)))
            return true;
        
        if(dp[i][j] != null)
            return dp[i][j];
        
        boolean ans = false;
        
        for(int k=i ; k<j ; k++)
        {
            if(wordDict.contains(s.substring(i,k+1)))
            {
                ans = helper(k+1 , j , s , wordDict , dp);
                
                if(ans)
                    break;
            }   
        }
        return dp[i][j] = ans;
    }
}