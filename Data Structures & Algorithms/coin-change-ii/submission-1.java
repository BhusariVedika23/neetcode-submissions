class Solution {
    public int change(int amount, int[] coins) {
        int[] ans = new int[amount + 1];
        ans[0]= 1;
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                ans[i] += ans[ i - coin]; 
            }
        }
        return ans[amount];
    }
}
