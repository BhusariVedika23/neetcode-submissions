class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }
    private void backtrack(int i, int n, int k, List<Integer> com){
        if(i > n){
            if(com.size() == k){
                result.add(new ArrayList<>(com));
            }
            return;
        }
        com.add(i);
        backtrack(i + 1, n, k, com);
        com.remove(com.size() - 1);
        backtrack(i + 1, n, k, com);
    }
}