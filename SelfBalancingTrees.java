/* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

     private static int balance(Node rootLeft, Node rootRight){
        return height(rootLeft) - height(rootRight);
    }

     private static int setHeight(Node root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max((root.left != null ? root.left.ht : -1), 
                            (root.right != null ? root.right.ht : -1));
        }

    private static Node leftRotate(Node root){
        Node newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.ht = setHeight(root);        
        newRoot.ht = setHeight(newRoot);        
        return newRoot;
    }
    
    private static Node rightRotate(Node root){
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.ht = setHeight(root);        
        newRoot.ht = setHeight(newRoot);        
        return newRoot;
    }
     
    private static int height(Node root){
        if(root == null){
            return -1;
        }else {
            return root.ht;
        }
    }
   static Node insert(Node root,int val)
    {
       if (root == null) {
           Node curr = new Node();
           curr.val = val;           
           return curr;
       }
       
       if (root.val < val) {
           root.right = insert(root.right, val);
       } else {
           root.left = insert(root.left, val);
       }
       int balance = balance(root.left, root.right);
       if(balance > 1){
            if(height(root.left.left) >= height(root.left.right)){
                root = rightRotate(root);
            }else{
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }else if(balance < -1){
            if(height(root.right.right) >= height(root.right.left)){
                root = leftRotate(root);
            }else{
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        else{
            root.ht = setHeight(root);           
        }
        return root;
    }
