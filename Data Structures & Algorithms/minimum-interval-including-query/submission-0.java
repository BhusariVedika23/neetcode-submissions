class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        for(int q : queries){
            int current = -1;
            for(int[] interval: intervals){
                int l = interval[0];
                int r = interval[1];
                if(l <= q && q <= r){
                    if(current == -1 || (r - l + 1) < current){
                        current = r - l + 1;
                    }
                }
            }
            result[index++] = current;
        }
        return result;
    }
}
