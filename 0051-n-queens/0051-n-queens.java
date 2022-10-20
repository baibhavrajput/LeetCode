class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        for(int i=0 ; i<n ; i++)
            Arrays.fill(board[i] , '.');
        
        List<List<String>> outer = new ArrayList<List<String>>();
        
        helper(0 , board , n , outer);
        
        return outer;
        
    }
    
    public void helper(int row , char[][] board , int n , List<List<String>> outer){
        
        if(row == n){
            ArrayList<String> inner = new ArrayList<>();
            
            for(int i=0 ; i<n ; i++)
                inner.add(String.valueOf(board[i]));
            
            outer.add(inner);
            return;
        }
        
        for(int col=0 ; col<n ; col++ )
        {    
            if(isSafe(row , col , board , n))
            {    
                board[row][col] = 'Q';
                helper(row+1 , board , n , outer);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean isSafe(int row , int col , char[][] board , int n){
        
        int tempRow = row;
        int tempCol = col;
        
        while(row >= 0 && col >= 0)
        {    
            if(board[row][col] == 'Q')
                return false;
            
            row--;
            col--;
        }
        
        row = tempRow;
        col = tempCol;
        
        while(row >= 0)
        {    
            if(board[row][col] == 'Q')
                return false;
            
            row--;
        }
        
        row = tempRow;
        col = tempCol;
        
        while(row >= 0 && col < n)
        {    
            if(board[row][col] == 'Q')
                return false;
            
            row--;
            col++;
        }
        return true;
    }
}