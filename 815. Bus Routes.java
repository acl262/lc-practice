class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
       
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int stop : routes[i]) {
                if(!stopToBus.containsKey(stop)) {
                    stopToBus.put(stop, new ArrayList<>());
                }
                stopToBus.get(stop).add(i);
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(source);
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for(int i= 0; i < size; i++) {
                int cur = queue.poll(); //stop
                List<Integer> buses = stopToBus.get(cur);
                for(int bus : buses) {
                    if(visited.contains(bus)) continue;
                    visited.add(bus);
                    for(int stop : routes[bus] ) {
                        if(stop == target) {
                            return res;
                        }
                        queue.add(stop);
                    }
                }
            }
        }
        
        return -1;
     }
}
