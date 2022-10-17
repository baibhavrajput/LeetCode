class Solution {
    public int countSquares(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        
        for(int i=0 ; i<n ; i++)
            count = count + matrix[i][0];
        
        for(int j=1 ; j<m ; j++)
            count = count + matrix[0][j];
        
        for(int i=1 ; i<n ; i++){
            for(int j=1 ; j<m ; j++){
                
                if(matrix[i][j] == 1){
                    matrix[i][j] = 1 + Math.min(matrix[i][j-1] , 
                                            Math.min(matrix[i-1][j] , matrix[i-1][j-1]));
                }
                
                count = count + matrix[i][j];
            }
        }
        
        return count;
    }
}