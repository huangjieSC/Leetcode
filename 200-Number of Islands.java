public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    markZero(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void markZero(char[][] grid, int row, int col){
         if(row<0 || row>=grid.length) return;
        if(col<0 || col>=grid[0].length) return;
        if(grid[row][col] == '0') return;
        
        grid[row][col]='0';
        markZero(grid, row-1, col);
        markZero(grid, row+1, col);
        markZero(grid, row, col-1);
        markZero(grid, row, col+1);
    }
}
