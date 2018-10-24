class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        
        boolean [] f = new boolean [n];
        
        f[0] = true;
        
        int i, j;
        
        for(j = 1; j < n; ++j) {
            f[j] = false;
            
            for(i =0; i < j ; ++i) {
                if(f[i] && i + nums[i] >= j) {
                    
                    f[j] =true;
                }
            }
            
            
        }
        
        return f[n-1];
    }
}
