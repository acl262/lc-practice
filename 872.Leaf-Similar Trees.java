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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
    if (root1 != null  && root2 == null) return false;
        
    if (root1 == null  && root2 != null) return false;
                
        List<Integer> l1 = findLeaf(root1);
                
        List<Integer> l2 = findLeaf(root2);
                        
        return l1.equals(l2);
        
    }
    
    
    public List<Integer> findLeaf(TreeNode root) {
        
        
            List<Integer> res = new LinkedList<>();
        
            if (root.left == null && root.right == null) {
                
                res.add(root.val);
    
            }
        
            else if (root.left == null && root.right != null) {   
                    
                  res =  findLeaf(root.right);    
                
            }
        
            else if (root.left != null && root.right == null) {   
                    
                  res =  findLeaf(root.left);    
                
            }
        
            else {
                  List<Integer> left = findLeaf(root.left);   
                        
                  List<Integer> right = findLeaf(root.right);
       
                  res = new LinkedList<>(left);
            
                  for(int i = 0; i < right.size(); i++) {
                                        
                      res.add(right.get(i));
                       
                       }
        }
        
         return res; 
            
    }
}
