class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;
        HashMap<String , ArrayList<String>> map = new HashMap<>();
        List<List<String>> outer = new ArrayList<List<String>>();
        
        for(int i=0 ; i<n ; i++){
            
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            
            String s = String.valueOf(temp);
            
            if(map.containsKey(s) == false)
                map.put(s , new ArrayList<String>());
            
            map.get(s).add(strs[i]);
        }
        
        for(String s : map.keySet())
            outer.add(map.get(s));
        
        return outer;
    }
}