class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int a = 1;
        int b = Arrays.stream(piles).max().getAsInt();
        int result = b;
        while( a <= b){
            int k = (a + b)/2;
            long totalTime = 0;
            for(int array : piles){
                totalTime += Math.ceil((double) array / k);
            }
            if(totalTime <= h){
                result = k;
                b = k - 1;
            }else{
                a = k + 1;
            }
        }
        return result;
    }
}
