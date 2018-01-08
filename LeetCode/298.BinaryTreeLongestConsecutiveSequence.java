/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Traverse + Divide and Conquer
class Solution {
    private int longest;
    public int longestConsecutive(TreeNode root) {
        longest = 0;
        helper(root);
        return longest;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        //Divide
        int left = helper(root.left);
        int right = helper(root.right);
        
        int subtreeLongest = 1; //at least we have root
        if(root.left != null && root.val + 1 == root.left.val ){
            subtreeLongest = Math.max(subtreeLongest, left + 1);
        }
        if(root.right != null && root.val + 1 == root.right.val ){
            subtreeLongest = Math.max(subtreeLongest, right + 1);
        }
        
        if(subtreeLongest > longest){
            longest = subtreeLongest;
        }
        return subtreeLongest;
    }
}