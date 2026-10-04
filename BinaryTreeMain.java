class Node{
    int data;
    Node left,right;
    Node(int val){
        data = val;
        Node left = right = null;
    }
}
class BST{
    Node root = null;

    Node insertNode(Node root, int val){
        if(root == null){
            root = new Node(val);
        }
        else if(val<root.data){
            root.left = insertNode(root.left, val);
        }
        else{
            root.right = insertNode(root.right, val);
        }
        return root;
    }
    void insert(int val){
        root = insertNode(root, val);
    }

    //Traversals
    void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + "");
        inorder(root.right);
    }

    void delete(int val){
        deleteNode(root, val);
    }

    Node deleteNode(Node root, int key){
        if(root == null){
            return;
        }
        if(root.data<key){
            root.data = deleteNode(root.left, key);
        }
        else if(root.data<key){
            return deleteNode(root.right, key);
        }
        else if(root.data == key){
            if(root.right == null && root.left == null){
                return null;
            }
            else if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }
            Node successor = findMin(root.right,data);
            root.data = successor.data;
            root.right = deleteNode(root.left, successor.data);
        }
        return root;
    }

    Node findMin(Node root, int data){
        while(root.left !=null){
            root = root.left;
        }
        return root;
    }
}
class Main {
    public static void main(String[] args) {
        BST b = new BST();
        b.insert(5);
        b.insert(6);
        b.insert(4);
        b.insert(8);
        b.insert(2);
        b.insert(5);
        b.inorder(b.root);
        System.out.println();
    }
}