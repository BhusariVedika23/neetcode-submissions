class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int case1 = expand(nums, 0, nums.length - 2);
        int case2 = expand(nums, 1, nums.length - 1);
        return Math.max(case1, case2);
    }

    private int expand(int[] nums, int start, int end){
        int first = 0;
        int second = 0;
        for(int i = start; i<= end; i++){
            int current = Math.max(second, first + nums[i]);
            first = second;
            second = current;
        }
        return second;
    }
}
