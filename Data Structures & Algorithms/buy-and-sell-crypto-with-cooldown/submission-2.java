class Solution {

    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {
            int preBuy = buy;
            int preSell = sell;
            int preCooldown = cooldown;

            buy = Math.max(preBuy, preCooldown - prices[i]);
            sell = preBuy + prices[i];
            cooldown = Math.max(preCooldown, preSell);
        }

        return Math.max(sell, cooldown);
    }
}