class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++){
            
            int ind = Math.abs(nums[i])-1;
            
            if(nums[ind] < 0)
                res.add(ind+1);
            
            nums[ind] = -nums[ind];
        }
        
        return res;
    }
}