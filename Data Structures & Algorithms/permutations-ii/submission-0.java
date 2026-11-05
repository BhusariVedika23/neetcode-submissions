class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums);
        return result;
    }
    private void dfs(int i, int[] nums){
        if(i == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) temp.add(num);
            result.add(temp);
            return;
        }
        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[i]) continue;
            swap(nums, i, j);
            dfs(i + 1, nums);
        }

        for(int j = nums.length - 1; j > i; j--){
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}