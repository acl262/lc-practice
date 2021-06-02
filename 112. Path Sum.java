/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasSumPath(root, targetSum, 0);
     }
    
    private boolean hasSumPath(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;
        int curSum = sum + root.val;
        if(root.left == null && root.right == null && curSum == targetSum) return true;
        return (hasSumPath(root.left, targetSum, curSum) || hasSumPath(root.right, targetSum, curSum));
        
    }
}
