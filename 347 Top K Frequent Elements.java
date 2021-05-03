class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        List<Pair> pairList = new ArrayList<>();
        for(int key : freqMap.keySet()) {
            pairList.add(new Pair(key, freqMap.get(key)));
        }
        // (a, b) -> (b.freq - a.freq)
        Queue<Pair> minHeap = new PriorityQueue<>(k, (a, b) -> (a.freq - b.freq));
        for(Pair pair: pairList) {
            minHeap.offer(pair);
            while(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // return minHeap.toArray();
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = minHeap.poll().num;
        }
        return res;
    }
}

class Pair {
    
    int num;
    int freq;
    public Pair(int num, int freq) {
        this.num = num;
        this.freq  = freq;
    }
}
