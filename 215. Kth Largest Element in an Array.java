class Solution {
    public int findKthLargest(int[] array, int k) {
       if(array == null || array.length < k) return 0;
       Queue<Integer> minHeap = new PriorityQueue<>();
       for(int num : array) {
         minHeap.offer(num);
         if(minHeap.size() > k) {
            minHeap.poll();
         }
       } 
        return minHeap.peek();
    }
}
