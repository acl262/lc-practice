class Solution {
    //输入一个非负整数数组nums, 和一个整数m， 把nums数组分成m个非空的连续子数组
    //求其中的一个分割，使得这个分割的连续子数组的和的最大值是所有分割里面最小的。
    //假设dp[i][j]是有i组， 然后在index=j的最大和， 那么, 考虑最后一个分组，
    // dp[i][j] = min(Math.max(dp[i-1][k] , sum[k+1, j])) // for 0 <= k < j
    // dp[1][j] = presum[j]
  
    public int splitArray(int[] nums, int m) {
        // dp[i][j] is the result with i group, and also ends at index j
    int total = 0;
    int[] presum = new int[nums.length];
    for(int i = 0; i < nums.length; ++i) {
        total += nums[i];
        presum[i] = total;
    }
    
    // dp[i][j] = min(Math.max(dp[i-1][k] , sum[k+1, j])) // for 0 <= k < j
    // corner case dp[1][j] = sum[0....j]
    int[][] dp = new int[m+1][nums.length];
    for(int i = 1; i <= m; ++i) {
        if(i == 1) {
            for(int j = 0; j < nums.length; ++j) {
                dp[i][j] = presum[j];
            }
        }
        else {
            for(int j = 0; j < nums.length; ++j) {
                int ret = Integer.MAX_VALUE;
                for(int k = 0; k < j; ++k) {
                    int sum = presum[j] - presum[k];
                    int v = Math.max(dp[i-1][k], sum);
                    ret = Math.min(ret, v);
                }
                dp[i][j] = ret;
            }
        }
    }
    return dp[m][nums.length-1];
    }
}
