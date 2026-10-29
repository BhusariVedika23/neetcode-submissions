class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int result = nums[0];

        for(int i = 0; i < n; i++){
            int current_sum = 0;
            for(int j = i; j < i + n; j++){
                current_sum += nums[j % n];
                result = Math.max(result, current_sum);
            }
        }
        return result;
    }
}