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
    public List<Integer> inorderTraversal(TreeNode root) {
        public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stk.isEmpty()) {
            while(cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
