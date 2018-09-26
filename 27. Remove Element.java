class Solution {
    
    // two pointers moving from the front and the end, respectivly.
    //  swap the front pointer value with the end pointer value if it is a target.
    //  adjust the end pointer to end-- after swap. otherwise, advance the front           //  pointer to next until the two pointer meet.
    public int removeElement(int[] nums, int val) {
        
        if (nums == null || nums.length == 0) return 0;
        
        int begin = 0, end = nums.length-1;
        
        while (begin <= end ) {
            
            if(nums[begin] == val) {
                
                nums[begin] = nums[end--];
            }
            
            else {
                begin++;
            }
            
        }
        
        return end +1;
           
       }

}