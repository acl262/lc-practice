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
    public TreeNode sortedArrayToBST(int[] nums) {

       if (nums == null) return null;

       TreeNode root = buildBST(nums, 0, nums.length-1);

       return root;
    }


    public TreeNode buildBST(int [] nums, int start,int end) {

        if (start > end) {
            return null;
            }

        int len = nums.length;

        int mid = (start + end)/2;

        TreeNode root = new TreeNode(nums[mid]);

        if(start <= mid-1) {
            root.left = buildBST(nums, start, mid-1);
        }

        if(end >= mid+1) {
            root.right = buildBST(nums, mid+1, end);
        }

       return root;

    }





}
