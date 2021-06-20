class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        
        int len = graph.length;
        
        for(int i = 0; i < len; i++) {
            boolean flag = findCylicNode(i, graph, visiting, visited);
            if (!flag) {
                res.add(i);
            }
            
        }   
        return res;
    }
    
    private boolean findCylicNode(int start, int[][] graph, Set<Integer> visiting, Set<Integer> visited) {
        if(visiting.contains(start)) return true;
        if(visited.contains(start)) return false;
        
        int[] nextNodes = graph [start];
        visiting.add(start);
        for(int node : nextNodes) {
            boolean flag = findCylicNode(node, graph, visiting, visited);
            if(flag) return true;
        }
        visiting.remove(start);
        visited.add(start);
        return false;
    }
}
