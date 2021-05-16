public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    	if(maze == null || maze.length == 0 || maze[0].length == 0) return 0;
    	int [][] dirs = new int[][] {{0,-1}, {0,1} {1, 0}, {-1,0}};
    	Queue<int []> q = new LinkedList<>();
    	int col = maze.length, row = maze[0].length;
    	boolean [][] visited = new boolean[col][row];
    	q.offer(start);
    	visited [start[0]][start[1]] = true;
    	int res = 0;
    	while (!q.isEmpty()) {
    		int size = q.size();
    		int[] cur = q.poll();
    		int x = cur[0];
    		int y = cur[1];
    		for(int size = 0; i < size; i++) {
    			for(int[] dir : dirs) {
    				while(x >= 0 && x  < col && y >= 0 && y < row && maze[x][y] == 0) {
		    			x = x + dir[0];
		    			y = y + dir[1];
		    			if(destination[0] == x && destination[1] == y) {
		    				return res;
		    			}
    				}
    				x = x - dir[0];
    				y = y - dir[1];
    				if(!visited[x][y]) {
	    				q.offer(new int[] {x, y});
	    				visited[x][y] = true;
	    			}
    			}
    		}
    	}

    	return -1;
    }
