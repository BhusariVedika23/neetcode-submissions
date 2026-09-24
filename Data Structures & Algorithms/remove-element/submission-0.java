class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> temp = new ArrayList<>();
        for(int num : nums){
            if(num != val){
                temp.add(num);
            }
        }
        for(int i = 0; i < temp.size(); i++){
            nums[i] = temp.get(i);
        }
        return temp.size();
    }
}