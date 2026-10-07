class Node{
    int data;
    Node left, right;
    int height;
    Node(int data){
        this.data = data;
        left = right = null;
        height = 1;
    }
}

class AVLTree{
    Node root;

    void insert(int data){
        root = insertNode(root,data);
    }
    Node insertNode(Node root, int key){
        if(root == null){
            root = new Node(key);
        }
        else if(key<root.data){
            root.left = insertNode(root.left,key);
        }
        else if(key>root.data){
            root.right = insertNode(root.right, key);
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalance(root);

        // LL case
        if(bf > 1 && key < root.left.data){
            return rightRotation(root);
        }
        return root;
    }

    int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    int getBalance(Node root){
        if(root == null) return 0;
        return height(root.left) - height(root.right);
    }

    //Rotations
    Node rightRotation(Node root){
        Node child = root.left;
        Node temp = child.right;

        child.right = root;
        root.left = temp;

        root.height = 1 + Math.max(height(root.left), height(root.right));

        child.height = 1 + Math.max(height(child.left), height(child.right));
        return child;
    }
}