class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] dp = new int[n + 1];

        for(int i = n - 1; i>=0; i--){
            dp[i] = 1 + dp[i +1];
            for(int j = i; j < n; j++){
                if(words.contains(s.substring( i, j + 1))){
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}