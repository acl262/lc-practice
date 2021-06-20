class Solution {
    
// 定义状态
// dp[i]：到nums[i]为止的最长递增子序列长度
// count[i]：到nums[i]为止的最长递增子序列个数
// 初始化状态
// dp = [1] * n：代表最长递增子序列的长度至少为1
// count = [1] * n：代表最长递增子序列的个数至少为1
// 状态转移
// 对于每一个数nums[i]，看在它之前的数nums[j](0<= j < i)是否比当前数nums[i]小，如果nums[i] > nums[j]，那么相当于到nums[j]为止的最长递增子序列长度到nums[i]增加了1，到nums[i]为止的最长递增子序列长度就变成了dp[i] = dp[j] + 1；但是因为满足nums[i] > nums[j] 的nums[j]不止一个，dp[i]应该取这些dp[j] + 1的最大值，并且这些dp[j] + 1还会有相等的情况，一旦相等，到nums[i]为止的最长递增子序列个数就应该增加了。因此，具体的状态转移如下，在nums[i] > nums[j]的大前提下：
// 如果dp[j] + 1 > dp[i]，说明最长递增子序列的长度增加了，dp[i] = dp[j] + 1，长度增加，数量不变 count[i] = count[j]
// 如果dp[j] + 1 == dp[i]，说明最长递增子序列的长度并没有增加，但是出现了长度一样的情况，数量增加 count[i] += count[j]
// 记录最长递增子序列的最大长度max_length
//遍历dp数组，如果dp数组记录的最大长度dp[i]等于max_length，将对应的数量count[i]加到结果res中


    public int findNumberOfLIS(int[] nums) {
    int n = nums.length;
        if(n == 1) return 1;

        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 0;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxLength){
                res += count[i];
            }
        }
        return res;
    }

}
