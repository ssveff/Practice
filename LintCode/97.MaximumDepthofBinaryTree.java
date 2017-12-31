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
//Traverse
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int depth;
    public int maxDepth(TreeNode root) {
        // write your code here
        depth = 0;
        helper(root, 1);
        return depth;
    }
    private void helper(TreeNode root, int curtDepth){
        if(root == null){
            return;
        }
        if (curtDepth > depth){
            depth = curtDepth;
        }
        helper(root.left, curtDepth + 1);
        helper(root.right, curtDepth + 1);
    }
}

//Divide and Conquer
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}