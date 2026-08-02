class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            String a = ticket.get(0);
            String b = ticket.get(1);
            map.computeIfAbsent(a, k -> new PriorityQueue<>()).offer(b);
        }
        List<String> result = new ArrayList<>();
        dfs(map, "JFK", result);

        Collections.reverse(result);
        return result;
    }
    private void dfs(Map<String, PriorityQueue<String>> map,
                     String a, List<String> result) {
        PriorityQueue<String> queue = map.get(a);
        while (queue != null && !queue.isEmpty()) {
            String b = queue.poll();
            dfs(map, b, result);
        }
        result.add(a);
    }
}
