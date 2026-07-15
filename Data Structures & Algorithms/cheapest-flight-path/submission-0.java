class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] tempPrice = Arrays.copyOf(price, n);
            for(int[] flight : flights){
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                if(price[s] == Integer.MAX_VALUE){
                    continue;
                }

                if(price[s] + p < tempPrice[d]){
                    tempPrice[d] = price[s] + p;
                }
            }
            price = tempPrice;
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
        
    }
}
