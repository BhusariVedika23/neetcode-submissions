class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));

        for(int i = 0; i < trips.length; i++){
            int currentPass = trips[i][0];
            for(int j = 0; j < i; j++){
                if(trips[j][2] > trips[i][1]){
                    currentPass += trips[j][0];
                }             
            }
            if(currentPass > capacity){
                return false;
            }
        }
        return true;
    }
}