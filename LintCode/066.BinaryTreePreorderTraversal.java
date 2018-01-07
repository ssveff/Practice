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
     * @return: Preorder in ArrayList which contains node values.
     */
    
    //Version 0: Non-recursive
    public List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

    //Version 1: Traverse
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    //把root为根的preorder加入list中
    private void traverse(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }

    //Version 2: Divide and Conquer
    public List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        //null or leaf
        if(root == null){
            return list;
        }
        
        //Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        //Conquer
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        
        return list;
    }
}