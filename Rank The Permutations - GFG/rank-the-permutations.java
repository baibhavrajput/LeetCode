//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long findRank(String s)
    {
        // Code here
        long n = s.length();
        long mul = helper(n);
        long ans = 1;
        
        int[] freq = new int[256];
        
        for(int i=0 ; i<n ; i++)
            freq[s.charAt(i)]++;
            
        for(int i=1 ; i<256 ; i++)
            freq[i] = freq[i] + freq[i-1];
            
        for(int i=0 ; i<n ; i++){
            
            mul = mul / (n-i);
            
            ans = ans + freq[s.charAt(i)-1] * mul;
            
            for(int j=s.charAt(i) ; j<256 ; j++)
                freq[j]--;
            
        }
        
        return ans;
        
    }
    
    public long helper(long n){
        
        if(n <= 1)
            return 1;
            
        return n * helper(n-1);
    }
}