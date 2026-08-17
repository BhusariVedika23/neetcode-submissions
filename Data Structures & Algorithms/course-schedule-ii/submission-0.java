class Solution {
    private List<Integer> output = new ArrayList<>();
    private int[] degree;
    private List<List<Integer>> adj;

    private void dfs(int node){
        output.add(node);
        degree[node]--;
        for(int nei : adj.get(node)){
            degree[nei]--;
            if(degree[nei] == 0){
                dfs(nei);
            }
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        degree = new int[ numCourses];
        for(int[] pre : prerequisites){
            degree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                dfs(i);
            }
        }
        if(output.size() != numCourses){
            return new int[0];
        }
        int[] result = new int[output.size()];
        for(int i = 0; i < output.size(); i++){
            result[i] = output.get(i);
        }
        return result;
    }
}
