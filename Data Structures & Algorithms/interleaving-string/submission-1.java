class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        if(n < m){
            String temp = s1;
            s1 = s2;
            s2 = temp;
            int templen = m;
            m = n;
            n = templen;
        }

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for(int i = m; i >= 0; i--){
            boolean nextDp = (i == m ? true : false);
            for(int j = n; j >= 0; j--){
                boolean result = ( j < n ? false : nextDp);
                if(i < m && s1.charAt(i) == s3.charAt(i + j) && dp[j]){
                    result = true;
                }
                if(j < n && s2.charAt(j) == s3.charAt(i + j) && nextDp){
                    result = true;
                }
                dp[j] = result;
                nextDp = dp[j];
            }
        }
        return dp[0];
    }
}
