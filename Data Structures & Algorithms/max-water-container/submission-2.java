class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int a = 0;
        int b = heights.length - 1;
        while(a < b){
            int area = Math.min(heights[a], heights[b])*(b - a);
            result = Math.max(result, area);
            if(heights[a] <= heights[b]){
                a++;
            }else{
                b--;
            }
        }
        return result;
    }
}
