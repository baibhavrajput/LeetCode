class Solution {
    public String destCity(List<List<String>> paths) {
        
        int n = paths.size();
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0 ; i<n ; i++)
            set.add(paths.get(i).get(0));
        
        for(int i=0 ; i<n ; i++){
            
            if(set.contains(paths.get(i).get(1)) == false)
                return paths.get(i).get(1);
        }
        
        return " ";
    }
}