class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;
        int [] res = new int[n];
        int ind = 0;
        
        for(int i=0 ; i<n ; i++){
            
            if(nums[i] < pivot)
            {
                res[ind] = nums[i];
                ind++;
            }
        }
        
        for(int i=0 ; i<n ; i++){
            
            if(nums[i] == pivot)
            {
                res[ind] = nums[i];
                ind++;
            }
        }
        
        for(int i=0 ; i<n ; i++){
            
            if(nums[i] > pivot)
            {
                res[ind] = nums[i];
                ind++;
            }
        }
        
        return res;
    }
}