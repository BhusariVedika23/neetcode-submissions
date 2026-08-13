class Solution {
    public boolean isMatch(String s, String p) {
        int a = s.length();
        int b = p.length();
        boolean[][] dp = new boolean[a + 1][b + 1];
        dp[a][b] = true;

        for (int i = a; i >= 0; i--) {
            for (int j = b - 1; j >= 0; j--) {
                boolean match = i < a && (s.charAt(i) == p.charAt(j) ||
                                          p.charAt(j) == '.');

                if ((j + 1) < b && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                    if (match) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j];
                    }
                } else if (match) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
        
    }
}
