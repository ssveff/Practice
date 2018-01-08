//Version 1: Traverse
public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }
        
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}

//Version 2: Divide and Conquer
public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    //Flatten root and return the last node
    private TreeNode helper(TreeNode root){
        if(root == null){
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        //connect leftLast to root.right
        if(leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if(rightLast != null){
            return rightLast;
        }
        
        if(leftLast != null){
            return leftLast;
        }
        
        return root;
    }
}

//Version 3: Non-recursive
public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            
            //connect
            node.left = null;
            if(stack.empty()){
                node.right = null;
            }
            else{
                 node.right = stack.peek();
            }
        }
    }
}