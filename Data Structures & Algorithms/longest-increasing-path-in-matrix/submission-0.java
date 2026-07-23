class Solution {

    int[][] direction = {{-1,0},{1,0},{0, -1},{0,1}};
    int[][] dp;
    private int dfs(int[][] matrix, int r, int c, int prevVal){
        int ROWS = matrix.length, COLS = matrix[0].length;
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS || matrix[r][c] <= prevVal){
            return 0;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int result = 1;
        for(int[] dir : direction){
            result = Math.max(result, 1 + dfs(matrix, r + dir[0], c + dir[1], matrix[r][c]));
        }
        return dp[r][c] = result;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int LIP = 0;
        dp = new int[ROWS][COLS];
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                dp[i][j] = -1;
            }
        }
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                LIP = Math.max(LIP, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }
        return LIP;
    }
}
