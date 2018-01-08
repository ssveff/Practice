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

//Divide and Conquer(这道题目traverse不好实现)
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
     
    //在root为根的二叉树中找A,B的LCA
    
    //如果找到了，就返回这个LCA
    //如果只碰到A，就返回A
    //如果只碰到B，就返回B
    //如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
        if(root == null || root == A || root == B){
            return root;
        }
        
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        //Conquer
        //如果找到了就返回这个LCA
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        //如果都没有，就返回null
        return null;
    }
}
