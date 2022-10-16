class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        Integer[][][] dp = new Integer[n+1][m+1][m+1]; 
        
        return helper(0 , 0 , m-1 , n , m , grid , dp);
    }
    
    public int helper(int i , int j1 , int j2 , int n , int m , int[][] grid , 
                      Integer[][][] dp)
    {     
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return Integer.MIN_VALUE;
        
        if(i == n-1)
        {
            if(j1 != j2)
                return grid[i][j1] + grid[i][j2];
            else
                return grid[i][j1];
        }
        
        if(dp[i][j1][j2] != null)
            return dp[i][j1][j2];
        
        int maxi = Integer.MIN_VALUE;
        int ans = 0;
        
        for(int dj1=-1 ; dj1<=1 ; dj1++)
        {
            for(int dj2=-1 ; dj2<=1 ; dj2++)
            {    
                if(j1 == j2){
                    ans = grid[i][j1] + helper(i+1 , j1+dj1 , j2+dj2 , n , m , grid , dp);
                }
                else
                    ans = grid[i][j1] + grid[i][j2] + 
                          helper(i+1, j1+dj1 , j2+dj2 , n , m , grid , dp);
                
                maxi = Math.max(maxi , ans);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}