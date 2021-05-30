class Solution {
    
    public int findPaths(int m, int n, int maxMove, int i, int j) {
        if(maxMove==0) return 0;
        int mod = 1000000007;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] dp = new int[m][n];
        for(int k = 0; k < maxMove; k++){
            int[][] tmp = new int[m][n];
            for(int x = 0; x < m; x++){
                for(int y = 0; y < n; y++){
                    for(int[]dir: dirs){
                        if(x + dir[0]<0 || x + dir[0] >= m || y + dir[1] < 0|| y + dir[1] >= n){
                            tmp[x][y] = (tmp[x][y]+1) % mod;
                        }else{
                            tmp[x][y] = (tmp[x][y] + dp[x+dir[0]][y+dir[1]]) % mod;
                        }
                    }
                }
            }
          dp = tmp;
        }
        return dp[i][j];
    }
}
