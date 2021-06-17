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

//DFS Solution
class Solution {
    
    private int maxLevel;
    private int sum;
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int level) {
        if(level > maxLevel) {
            maxLevel = level;
            sum = 0;
        }
        if(level == maxLevel) {
            sum += root.val;
        }
        
        if(root.left != null) {
            dfs(root.left, level +1);
        } 
        
        if(root.right != null) {
            dfs(root.right, level +1);
        } 
    } 
}
