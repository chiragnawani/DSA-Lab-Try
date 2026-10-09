class Node{
    int data;
    String color;
    Node left, right, parent;

    Node(int val){
        data = val;
        color = "R";
        left = right = parent = null;
    }
}

class RedBlackTree{
    Node root;
    
    Node temp;
    insert(int data){
        insertNode(root,temp,val);
        root.color = "B";
    }
    insertNode(Node root, Node temp, int val){ 
        if(root == null){
            root = new Node(val);root.parent = temp;
        }else if(val<root.data){
            temp = root;
            root.left = insertNode(root.left,temp,val);
        }else{
            temp = root;
            root.right = insertNode(root.right,temp,val);
        }


        //colors
        if(root.parent == null){
            root.color = "B";
        }

        //Deciding left or right uncle
        Node uncle;
        if(root.parent!= null && root.parent.parent!= null){
            if(root.parent == root.parent.parent.left){
                uncle = root.parent.parent.right;
            }
            else{
                uncle = root.parent.parent.left;
            }
            if(uncle !=null && root.parent.color == "R" && uncle.color == "R"){
                root.parent.color = "B";
                uncle.color = "B";
                root.parent.parent.color = "R";
            }
            if(root.parent.color == "R" && (uncle.color == "B" || uncle == null)){
                //4 cases
                //LL Case
                if(root.data<root.parent.data && root.parent.data<root.parent.parent.data){
                   root = rightRotate(root.parent);
                }

            }
        }
    }

    Node rightRotation(Node root){
        Node child = root.left;
        Node temp = child.right;

        child.right = root;
        root.left = temp;

        return child;
    }

    Node leftRotation(Node root){
        Node rightChild = root.right;
        Node temp = rightChild.left;

        rightChild.left = root;
        root.right = temp;

        return root;
    }
}