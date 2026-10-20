class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int curSum = 0;
            int j = i;
            while(j < n){
                curSum += nums[j];
                if(curSum >= target){
                    result = Math.min(result, j - i + 1);
                    break;
                }
                j++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}