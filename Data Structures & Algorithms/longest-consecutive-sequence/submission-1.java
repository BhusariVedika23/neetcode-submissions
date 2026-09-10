class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        int current = nums[0];
        int streak = 0;
        int i = 0;
        while(i < nums.length){
            if(current != nums[i]){
                current = nums[i];
                streak = 0;
            }
            while(i < nums.length && nums[i] == current){
                i++;
            }
            streak++;
            current++;
            result = Math.max(result, streak);
        }
        return result;
    }

}
