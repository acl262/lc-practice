class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] valid = new int[m];
        
        //获取每一排的二进制串
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp = tmp * 2 + (seats[i][j] == '.'? 1 : 0);
            }
            valid[i] = tmp;
        }
        
        int maxSize = 1 << n;   //每一排代表的二进制串所能达到的最大值 + 1
        //dp[i][j]：第i行是j二进制串的情况下，前i行所能容纳的最大人数
        int[][] dp = new int[m][maxSize];	//记录每一种可能情况
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < maxSize; j++) {
                dp[i][j] = -1;
            }
        }
        
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < maxSize; j++) {
            	//(j & valid[i]) == j：子集
            	//((j >> 1) & j) == 0：左右两边不能坐人
                if ((j & valid[i]) == j && ((j >> 1) & j) == 0) {
                    if (i == 0) {
                        dp[i][j] = Math.max(dp[i][j], Integer.bitCount(j));
                    }
                    else {
                        for (int k = 0; k < maxSize; k++) {
                        	//dp[i-1][k] != -1：前一行是k时是有效的（满足了两个基本条件）
                        	//((j << 1) & k) == 0：左上不能坐人
                        	//((j >> 1) & k) == 0：右上不能坐人
                            if (dp[i-1][k] != -1 && ((j << 1) & k) == 0 && ((j >> 1) & k) == 0) {
                                dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Integer.bitCount(j));
                            }
                        }
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res;
    }
}
