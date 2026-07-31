class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> map;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        time = 0;
        map = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{ time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));   
        for(int followeeId: map.getOrDefault(userId, new HashSet<>())){
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }
        feed.sort((a,b) -> b[0] - a[0]);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< Math.min(10, feed.size()); i++){
            result.add(feed.get(i)[1]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            map.putIfAbsent(followerId, new HashSet<>());
            map.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        map.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
