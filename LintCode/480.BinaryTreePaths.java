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
    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    //遍历算法Traverse
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if(root == null){
            return result;
        }
        helper(root, Integer.toString(root.val), result);
        return result;
    }
    private void helper(TreeNode root, String path, List<String> result){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }
        if(root.left != null){
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        if(root.right != null){
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }

}


public class Solution {
    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    
    //Divide and Conquer
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for(String path: leftPaths){
            paths.add(root.val + "->" + path);
        }
        for(String path: rightPaths){
            paths.add(root.val + "->" + path);
        }
        
        //root is leaf
        if(root.left == null && root.right == null){
            paths.add(root.val + "");
        }
        
        return paths;
    }
}