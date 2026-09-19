class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorts = new String(charArray);
            result.putIfAbsent(sorts, new ArrayList<>());
            result.get(sorts).add(s);
        }
        return new ArrayList<>(result.values()); 
    }
}
