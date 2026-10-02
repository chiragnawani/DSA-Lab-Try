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