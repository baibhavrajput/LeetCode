//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);
            
            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int arr[], int n){
        // code here 1 2 2 3 3 3  // 1 2 3
        int[] res = new int[n];
        res[0] = arr[0];
        
        int ind = 1;
        
        for(int i=1 ; i<n ; i++)
        {
            if(arr[i-1] == arr[i])
                continue;
                
            else if(arr[i-1] != arr[i])
            {
                res[ind] = arr[i];
                ind++;
            }
        }
        
        for(int i=0 ; i<ind ; i++)
            arr[i] = res[i];
            
        return ind;
    }
}