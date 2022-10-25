class Tuple{
    int start;
    int end ;
    int profit;
    
    public Tuple(int _start , int _end , int _profit){
        start = _start;
        end = _end;
        profit = _profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = profit.length;
        Tuple[] arr = new Tuple[n];
        
        for(int i=0 ; i<n ; i++)
            arr[i] = new Tuple(startTime[i] , endTime[i] , profit[i]);
        
        Arrays.sort(arr , (a,b) -> a.start - b.start);
        
        Integer[] dp = new Integer[n+1];
        
        return helper(0 , arr , n , dp);
    }
    
    public int helper(int ind , Tuple[] arr , int n , Integer[] dp){
        
        if(ind >= n)
            return 0;
        
        if(dp[ind] != null)
            return dp[ind];
        
        int nextInd = findNextInd(ind , arr , n);
        
        int pick = arr[ind].profit + helper(nextInd , arr , n , dp);
        int notPick = helper(ind+1 , arr , n , dp);
        
        return dp[ind] = Math.max(pick , notPick);
    }
    
    public int findNextInd(int ind , Tuple[] arr , int n){
        
        int ans = n;
        
        int left = ind+1;
        int right = n-1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(arr[ind].end <= arr[mid].start){
                ans = mid;
                right = mid-1;
            }
            else
                left = mid + 1;
        }
        
        return ans;
    }
}