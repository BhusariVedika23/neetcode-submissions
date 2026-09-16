class Solution {
    public int maxProfit(int[] prices) {
        int low = 0;
        int high = 1;
        int maxP = 0;
        while(high < prices.length){
            if(prices[low] < prices[high]){
                int profit = prices[high] - prices[low];
                maxP = Math.max(maxP, profit);
            } else {
                low = high;
            }
            high++;
        }
        return maxP;
    }
}
