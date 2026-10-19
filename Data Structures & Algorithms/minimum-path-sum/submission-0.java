class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows + 1][cols + 1];

        for(int r = 0; r <= rows; r++){
            for(int c = 0; c <= cols; c++){
                dp[r][c] = Integer.MAX_VALUE;
            }
        }
        dp[rows - 1][cols] = 0;

        for(int r = rows - 1; r >= 0; r--){
            for(int c = cols - 1; c >= 0; c--){
                dp[r][c] = grid[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
            }
        }
        return dp[0][0];
    }
}