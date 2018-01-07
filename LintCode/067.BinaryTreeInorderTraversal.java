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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */

    //Version0: Non-recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    //Version1: Traverse
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traverse(root, list);
        return list;
    }
    private void traverse(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    //Version2: Divide and Conquer
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        //Null or leaf
        if(root == null){
            return list;
        }
        //Divide
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        
        //Conquer
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        
        return list;
    }
}