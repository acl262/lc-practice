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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null ) return null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(val == cur.val) {
                return cur;
            }
            if(cur.left != null) {
                q.offer(cur.left);
            } 
            
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        
        return null;
    }
}
