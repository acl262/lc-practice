class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int j =0;
        
        int x = A.length -1;
        
       
       for(int i =0; i < A.length; i++) {    
       
            if (A[i] % 2 == 0) {
                
                res[j] = A[i];
                j ++; 
                
            }
               
            else {
                
                res[x] = A[i];
                x --;
            }
        }
        
        return res;
        
    }
}
