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

//Traverse: without Result Type
public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}


//Divide and Conquer:先判断左右子树是否为balanced binary tree，再判断左右子树高度是否相差小于1.

class ResultType{
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth){
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    //递归三要素：
    //1.得到以root为根的二叉树是不是平衡的，以及它的高度是多少
    private ResultType helper(TreeNode root){
        //3.出口
        if(root == null){
            return new ResultType(true, 0);
        }
        
        //2.split:得到左右子树是否平衡，以及高度信息
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        //subtree not balanced
        if(!left.isBalanced || !right.isBalanced){
            return new ResultType(false, -1);
        }
        
        //root not balanced
        if(Math.abs(left.maxDepth - right.maxDepth) > 1){
            return new ResultType(false, -1);
        }
        
        int depth = Math.max(left.maxDepth, right.maxDepth) + 1;
        return new ResultType(true, depth);
    }
}