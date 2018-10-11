class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int lgh = grid[0].length;

        int leftToright [] = new int [lgh];

        int topTobotton [] = new int [lgh];

        int res = 0;

        for(int i = 0; i < lgh; i++) {

            leftToright[i] = findMax(grid[i]);

            System.out.print("lefttoright" + leftToright[i] + "\n" );

            topTobotton = findHMax(grid);
            //   System.out.println("lefttoright" + leftToright[i] );
        }

           for(int i = 0; i < lgh; i++) {

             for(int j = 0; j < lgh; j++) {

                int cur = findMin(leftToright[i],  topTobotton[j]);

                int dif = cur - grid[j][i];

                res += dif;

        }
      }

        return res;


    }

    public int findMin(int x, int y) {
            int res = x;
            if (x >y) {
                res = y;
              }
            return res;
            }


    public int findMax ( int [] len) {
        int max = len[0];

        for(int i = 1; i < len.length; i++) {
            if(len[i] >max) {
                max = len[i];
            }
        }
        return max;
    }


    public int[] findHMax ( int [][] grid) {
          int [] toptoright  = new int [grid[0].length];
          int max =0;

        for(int i = 0; i < grid[0].length; i++) {
            max = grid[0][i];

            for(int j = 0; j < grid[0].length; j++) {
                if(grid[j][i] >max) {
                    max = grid[j][i];
                  }
        }
           toptoright [i] = max;
    }
           return toptoright;
      }
}
