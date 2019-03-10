class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++) {
       // for(Integer i: A) {
            res[i] = A[i] * A[i] ;
        }
        
        Arrays.sort(res);
        return res;
        
    }
}