class Solution {
    Boolean[][] demo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        demo = new Boolean[n][sum / 2 + 1];
        return dfs(nums, 0, sum/2);
    }

    public boolean dfs(int[] nums, int i, int target){
        if(i == nums.length) {
            return target == 0;
        }
        if(target < 0){
            return false;
        }
        if(demo[i][target] != null){
            return demo[i][target];
        }
        demo[i][target] = dfs(nums, i + 1, target)|| dfs(nums, i+1, target - nums[i]);
        return demo[i][target];
    }
}
