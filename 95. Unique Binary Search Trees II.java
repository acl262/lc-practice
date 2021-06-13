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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return dfs(1, n);
    }
    
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
            return res;
        }
        
        if(start == end) {
            TreeNode tn = new TreeNode(start);
            res.add(tn);
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftTree = dfs(start, i-1);           
            List<TreeNode> rightTree = dfs(i+1, end);
            
            for(TreeNode left : leftTree) {
                for(TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
        
    }
    

}
