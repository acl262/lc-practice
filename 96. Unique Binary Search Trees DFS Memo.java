class Solution {
    public int numTrees(int n) {
        if(n == 0) {
            return 0;
        }
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        dfs(n, memo);
        return memo[n];
    }
    
    private int dfs(int n, int [] memo) {
        if(n <= 1) {
            memo[1] = 1;
            return 1;
        }
        if(memo[n] != -1) return memo[n];
       
        int count = 0;
        for(int i = 1; i <= n; i++) {
            int leftNum = dfs(i-1, memo);           
            int rightNum = dfs(n-i, memo);
            
            count += leftNum * rightNum;
            memo[n] = count;
        }
        return count;
        
    }
}
