class Solution {
    private int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int islands =0;
        for(int row =0; row< grid.length; row++){
            for(int col = 0; col< grid[row].length; col++){
                if(grid[row][col] =='1'){
                    dfs(grid, row, col);
                    islands++;
                }
                
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int row, int col){
        if(col< 0 || row<0 || row>= grid.length || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }
        grid[row][col]= '0';
        for(int[] dir:directions){
            dfs(grid, row +dir[0], col+dir[1]);            
        }
    }
}
