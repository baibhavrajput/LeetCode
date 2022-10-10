class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        
        ArrayDeque<Integer> st = new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0 ; i<m ; i++)
        {
            while(st.isEmpty() == false && nums2[st.peek()] < nums2[i])
                map.put(nums2[st.pop()] , nums2[i]);
            
            st.push(i);
        }
        
        for(int i=0 ; i<n ; i++)
            nums1[i] = map.getOrDefault(nums1[i] , -1);
        
        return nums1;
    }
}