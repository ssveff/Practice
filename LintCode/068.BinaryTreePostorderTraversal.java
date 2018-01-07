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
     * @return: Postorder in ArrayList which contains node values.
     */
    //Version0: Non-recurisve
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; //previously traversed node
        TreeNode curr = root;
        
        if(root == null){
            return list;
        }
        stack.push(root);
        
        while(!stack.empty()){
            curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr){ //traverse down the tree
                if(curr.left != null){
                    stack.push(curr.left);
                }
                else if(curr.right != null){
                    stack.push(curr.right);
                }
            }
            else if(curr.left == prev){ //traverse up the tree from the left
                if(curr.right != null){
                    stack.push(curr.right);
                }
            }
            else{  //traverse up the tree from the right
                list.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return list;
    }

    //Version1: Traverse
    public List<Integer> postorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
       traverse(root, list);
       return list;
    }
    private void traverse(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }

    //Version2: Divide and Conquer
    public List<Integer> postorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
       if(root == null){
           return list;
       }
       
       //Divide
       List<Integer> left = postorderTraversal(root.left);
       List<Integer> right = postorderTraversal(root.right);
       
       //Conquer
       list.addAll(left);
       list.addAll(right);
       list.add(root.val);
       
       return list;
    }
}