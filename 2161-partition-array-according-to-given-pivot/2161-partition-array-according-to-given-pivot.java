class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;
        int [] res = new int[n];
        int i = 0;
        int j = n-1;
        int lessThanInd = 0;
        int greaterThanInd = n-1;
        
        while(i < n && j >= 0){
            
            if(nums[i] < pivot){
                res[lessThanInd] = nums[i];
                lessThanInd++;
            }
            
            if(nums[j] > pivot){
                res[greaterThanInd] = nums[j];
                greaterThanInd--;
            } 
            
            i++;
            j--;
        }
        
        for( i=lessThanInd ; i<=greaterThanInd ; i++){
            res[i] = pivot;
        }
        
        return res;
    }
}