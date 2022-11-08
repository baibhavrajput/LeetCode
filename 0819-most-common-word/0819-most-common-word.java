class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        
        String[] arr = paragraph.
                       replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().split(" ");
        
        int n = arr.length;
        
        HashMap<String , Integer> map = new HashMap<>();
        
        for(int i=0 ; i<n ; i++){
            if(Arrays.asList(banned).contains(arr[i]) == false && arr[i] != ""){
                map.put(arr[i] , map.getOrDefault(arr[i] , 0)+ 1);
            }
        }
        
        
        String ans = null;
        int maxi = 0;
        
        for(int i=0 ; i<n ; i++){
            
            if(map.containsKey(arr[i]) && map.get(arr[i]) > maxi){
                ans = arr[i];
                maxi = map.get(arr[i]);
            }
        }
        
        return ans;
    }
}