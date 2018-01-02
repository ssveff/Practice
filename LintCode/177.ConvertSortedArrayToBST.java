/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    public TreeNode sortedArrayToBST(int[] A) {
        int length = A.length;
        if(length == 0){
            return null;
        }
        TreeNode root = helper(A, 0, length - 1);
        return root;
    }
    public TreeNode helper(int[] A, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, left, mid - 1);
        node.right = helper(A, mid + 1, right);
        return node;
    }
}