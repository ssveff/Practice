class BinarySearchTree{
  class Node{
    int key;
    Node left, right;
    
    public Node(int x){
      key = x;
      left = null;
      right = null;
    }
  }
  
  Node root;
  
  BinarySearchTree(){
    root = null;
  }
  
  private Node insertNode(Node root, int key){
    if(root == null){
      root = new Node(key);
      return root;
    }
    
    if (key < root.key){
      root.left = insertNode(root.left, key);
    }
    else{
      root.right = insertNode(root.right, key);
    }
    return root;
  }
  
  public void insert(int key){
    root= insertNode(root, key);
  }
  
  private Node deleteNode(Node root, int key){
    if(root == null){
      return root;
    }
    
    if(key < root.key){
      root.left = deleteNode(root.left, key);
    }
    else if(key > root.key){
      root.right = deleteNode(root.right, key);
    }
    else{
      if(root.left == null){
        return root.right;
      }
      else if(root.right == null){
        return root.left;
      }
      
      root.key = minNode(root.right);
      root.right = deleteNode(root.right, root.key);

    }
    
    return root;
  }
  
  public int minNode(Node root){
    int min = root.key;
    while(root.left != null){
      min = root.left.key;
      root = root.left;
    }
    return min;
  }
  
  public void delete(int key){
    root = deleteNode(root, key);
  }
  
  private void printBST(Node root){
    if(root == null){
      return;     
    }
    
    printBST(root.left);
    System.out.print(root.key);
    printBST(root.right);
  }
  
  public void print(){
    printBST(root);
  }
  
  public static void main(String[] args){
    BinarySearchTree tree = new BinarySearchTree();
    for(int i = 1; i < 11; i++){
      tree.insert(i);
    }
    tree.print();
    tree.delete(4);
    tree.delete(6);
    tree.print();
  }
}