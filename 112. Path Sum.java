/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        boolean res = false;
        
        if(root == null) return false;
        
        if (root != null && root.left == null && root.right == null )  {
            
            return sum == root.val;
        }
        
        if (root.left != null) {
            
            res = hasPathSum(root.left, sum - root.val);
            
             if (res) return res;
        }
        
       
        
         if (root.right != null) {
            
            res = hasPathSum(root.right, sum - root.val);
            
            
        }
        
        return res;
        
            
        
    }
}