class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int V = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        
        int[] vis = new int[V];
        Arrays.fill(vis , 0);
        
        int[] dfsVis = new int[V];
        Arrays.fill(dfsVis , 0);
        
        for(int i=0 ; i<V ; i++){
            if(adj.get(i) != null && vis[i] == 0)
                if(helper(i , vis , dfsVis , adj))
                    return false;
        }
        return true;
    }
    
    public boolean helper(int curr , int[] vis , int[] dfsVis , 
                          List<List<Integer>> adj)
    {
        vis[curr] = 1;
        dfsVis[curr] = 1;
        
        for(int it : adj.get(curr)){
            if(vis[it] == 0){
                if(helper(it , vis , dfsVis , adj ) == true)
                    return true;
            }
            else if(dfsVis[it] == 1)
                    return true;
        }
        dfsVis[curr] = 0;
        vis[curr] = 1;
        return false;
    }
}