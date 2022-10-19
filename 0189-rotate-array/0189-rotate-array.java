class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k % n;
        
        reverse(n-k , n-1 , nums);
        reverse(0 , n-k-1 , nums);
        reverse(0 , n-1 , nums);
    }
    
    public void reverse(int i , int j , int[] arr){
        
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
    }
}