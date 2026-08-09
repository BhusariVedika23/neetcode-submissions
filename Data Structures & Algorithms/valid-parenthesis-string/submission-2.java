class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n + 1][n + 1];

        dp[n][0] = true;

        for (int i = n - 1; i >= 0; i--) {

            for (int balance = 0; balance <= n; balance++) {

                if (s.charAt(i) == '*') {

                    if (balance + 1 <= n) {
                        dp[i][balance] |= dp[i + 1][balance + 1];
                    }


                    if (balance > 0) {
                        dp[i][balance] |= dp[i + 1][balance - 1];
                    }

                    dp[i][balance] |= dp[i + 1][balance];

                } else if (s.charAt(i) == '(') {
                    if (balance + 1 <= n) {
                        dp[i][balance] = dp[i + 1][balance + 1];
                    }

                } else {
                    if (balance > 0) {
                        dp[i][balance] = dp[i + 1][balance - 1];
                    }
                }
            }
        }

        return dp[0][0];
    }
}