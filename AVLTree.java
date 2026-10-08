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

        if(bf > 1 && key < root.left.data){
            root = leftRotation(root);
        }
        else if(bf<-1 && key>root.right.data){
            root = rightRotation(root);
        }
        else if(bf>1 && key>root.left.data){
            root.left = leftRotation(root.left);

            root = rightRotation(root);
        }
        else if(bf<-1 && key<root.right.data){
            root.right = rightRotation(root.right);
            root = leftRotation(root);            
        }
        return root;
    }


    void delete(int data){
        root = deleteNode(root,data);
    }
    Node deleteNode(Node root, int key){
        if(root == null){
            return null;
        }else if(key<root.data){
            root.left = deleteNode(root.left, key);
        }else if(key>root.data){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                Node successor = findMin(root.right);
                root.data = successor.data;
                root.right = deleteNode(root.left, successor.data);
            }
        }
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bf = getBalance(root);


        if (bf > 1 && getBalance(root.left) >= 0) {
            root = rightRotation(root);
        }
        else if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotation(root.left);
            root = rightRotation(root);
        }
        else if (bf < -1 && getBalance(root.right) <= 0) {
            root = leftRotation(root);
        }
        else if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotation(root.right);
            root = leftRotation(root);
        }
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

    Node leftRotation(Node root){
        Node rightChild = root.right;
        Node temp = rightChild.left;

        rightChild.left = root;
        root.right = temp;

        root.height = 1 + Math.max(height(root.left), height(root.right));
        rightChild.height = 1 + Math.max(height(rightChild.left), height(rightChild.right));

        return root;
    }


    findMin(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}