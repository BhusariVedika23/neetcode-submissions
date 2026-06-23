class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return track(0, 0, nums, target);
    }
    private int track(int i, int total, int[] nums, int target){
        if(i == nums.length){
            return total == target ? 1 : 0;
        }
        return track( i+1, total + nums[i], nums, target) + track(i + 1, total - nums[i], nums, target);
    }
}
