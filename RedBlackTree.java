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
    void insert(int data){
        root = insertNode(root,temp,data);
        root.color = "B";
    }
    Node insertNode(Node root, Node temp, int val){
        if(root == null){
            root = new Node(val);root.parent = temp;
        }else if(val<root.data){
            temp = root;
            root.left = insertNode(root.left,temp,val);
        }else{
            temp = root;
            root.right = insertNode(root.right,temp,val);
        }
        fixInsert(root);
        return root;
    }



    void fixInsert(Node root){
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
            if(root.parent.color == "R" && (uncle == null || uncle.color == "B")){
                Node p = root.parent;
                Node gp = root.parent.parent;
                //4 cases


                //LL Case
                if(root == root.parent.left && root.parent == root.parent.parent.left){
                }

            }
        }
    }

    Node rightRotate(Node root){
        Node leftChild = root.left;
        Node temp = leftChild.right;
        Node oldParent = root.parent;

        leftChild.right = root;
        root.left = temp;

        if(temp!= null && temp.parent!=null){
            temp.parent = root;
        }
        if(oldParent!=null)
        leftChild.parent = oldParent;
        root.parent = leftChild;

        return leftChild;
    }

    Node leftRotation(Node root){
        Node rightChild = root.right;
        Node temp = rightChild.left;

        rightChild.left = root;
        root.right = temp;

        return root;
    }


    Node rightRotate(Node x){
        Node y = x.left;
        Node T2 = y.right;

        Node oldParent = x.parent;

        x.left = T2;

        if (T2 != null) {
            T2.parent = x;
        }

        y.parent = oldParent;

        y.right = x;
        x.parent = y;

        if(oldParent == null){
            root = y;
        }
        else if(x == oldParent.left){
            oldParent.left = y;
        }else{
            oldParent.right = y;
        }
        return y;
    }
}