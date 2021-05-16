public class ShortestDistance {
  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = new int [][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int[][] distance = new int[m][n];

        for (int[] row: distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir: dirs) {
                int nrow = cur[0];
                int ncol = cur[1];
                int count = 0;

                nrow = nrow + dir[0];
                ncol = ncol + dir[1];

                while (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] == 0) {
                    nrow += dir[0];
                    ncol += dir[1];
                    count++;
                }

                if (distance[cur[0]][cur[1]] + count < distance[nrow][ncol]) {
                    distance[nrow][ncol] = distance[cur[0]][cur[1]] + count;
                    queue.offer(new int[] {nrow, ncol});
                }

            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? 
                    -1 : distance[destination[0]][destination[1]];
    }
}
