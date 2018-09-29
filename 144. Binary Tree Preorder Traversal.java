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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
       
        if( root == null) return res;
        
        helper(root, res);
        
        return res;
        
        
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        
        res.add(root.val);
        
        if(root.left != null) {
            
            helper(root.left, res);
        }
        
         if(root.right != null) {
            
            helper(root.right, res);
        }
        
    }
    
    
}
