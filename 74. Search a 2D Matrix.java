class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        Queue<int[]> q = new LinkedList<>();
        int col = matrix.length, row = matrix[0].length;
        boolean[][] visited = new boolean [col][row];
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(target == matrix[cur[0]][cur[1]]) {
                return true;
            }
            if(cur[0] + 1 < col && !visited [cur[0]+1][cur[1]]) {
                q.offer(new int[] {cur[0]+1, cur[1]});
                visited[cur[0]+1][cur[1]] = true;
            }
            if(cur[1] + 1 < row && !visited [cur[0]][cur[1]+1] ) {
                q.offer(new int[] {cur[0], cur[1]+1});
                visited [cur[0]][cur[1]+1] = true;
            }
        }
        return false;
    }
}
