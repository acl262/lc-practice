class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
       int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int len = 1; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                int left = root - 1; 
                int right = len - root; 
                dp[len] += dp[left] * dp[right];
            }
        }
            return dp[n];
        }
}
