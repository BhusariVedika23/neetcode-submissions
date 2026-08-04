class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] num = new int[n + 2];
        num[0] = num[n + 1] = 1;
        for(int i = 0; i < n; i++){
            num[i + 1] = nums[i];
        }
        int[][] array = new int[n + 2][n + 2];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                array[i][j] = -1;
            }
        }
        return dfs(num, 1, num.length - 2, array);
    }
    public int dfs(int[] nums, int l, int r, int[][] array){
        if(l > r){
            return 0;
        }
        if(array[l][r] != -1){
            return array[l][r];
        }
        array[l][r] = 0;
        for(int i = l; i <= r; i++){
            int coins = nums[l - 1] * nums[i] * nums[ r + 1];
            coins += dfs(nums, l, i - 1, array) + dfs(nums, i + 1, r, array);
            array[l][r] = Math.max(array[l][r], coins);
        }
        return array[l][r];
    }
}
