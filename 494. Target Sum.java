class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        int [] res = new int[1];
        dfs(nums,0, 0,res, S);
        
        return res[0];
    }
    
    public void dfs(int[] nums, int start, int target, int [] res, int S) {
        
        if(start == nums.length && S == target  ) {
            res[0]++;
            return;
        }
        
        if(start >= nums.length) {
            return;
        }
        
        dfs(nums, start+1,target-nums[start],res, S);
        dfs(nums, start+1,target+nums[start],res, S);
        
    }
}
