class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();
        
        HashMap<Character , Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++)
            map.put(s.charAt(i) , i);
        
        int maxi = Integer.MIN_VALUE;
        int prev = -1;
        
        for(int i=0 ; i<n ; i++)
        {    
            maxi = Math.max(maxi , map.get(s.charAt(i)));
            
            if(i == maxi)
            {
                ans.add(i - prev);
                maxi = Integer.MIN_VALUE;
                prev = i;
            }
        }
        return ans;
    }
}