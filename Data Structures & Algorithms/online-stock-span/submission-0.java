class StockSpanner {
    private List<Integer> array;

    public StockSpanner() {
        array = new ArrayList<>();
    }
    
    public int next(int price) {
        array.add(price);
        int i = array.size() - 2;
        while(i >= 0 && array.get(i) <= price){
            i--;
        }
        return array.size() - i - 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */