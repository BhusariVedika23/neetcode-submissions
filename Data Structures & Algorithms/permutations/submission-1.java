class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return Arrays.asList(new ArrayList<>());
        }
        List<List<Integer>> list = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> lists : list){
            for(int i = 0; i <= lists.size(); i++){
                List<Integer> lists_copy = new ArrayList<>(lists);
                lists_copy.add(i, nums[0]);
                result.add(lists_copy);
            }
        }
        return result;
    }
}
