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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}