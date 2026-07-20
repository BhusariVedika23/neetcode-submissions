class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : hand){
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet());
        while(!queue.isEmpty()){
            int first = queue.peek();
            for(int i = first; i< first + groupSize; i++){
                if(!map.containsKey(i)){
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    if(i != queue.peek()){
                        return false;
                    }
                    queue.poll();
                }
            }
        }
        return true;
    }
}
