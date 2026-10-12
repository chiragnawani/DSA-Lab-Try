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
    Node inserted;
    void insert(int data){
        inserted = null
        root = insertNode(root,temp,data);
        if(inserted!=null){
            fixInsert(inserted);
        }
        root.color = "B";
    }
    Node insertNode(Node root, Node temp, int val){
        if(root == null){
            Node newNode = new Node(val);
            root.parent = temp;
            inserted = newNode;
            return newNode;
        }else if(val<root.data){
            root.left = insertNode(root.left,root,val);
        }else if {
            root.right = insertNode(root.right,root,val);
        }else{
            return root;
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
                    root = rightRotate(root);
                }
                //RR Case
                else if(root == root.parent.right && root.parent == root.parent.parent.right){
                }
                //RL Case
                else if(root == root.parent.left && root.parent == root.parent.parent.right){
                }
                //LR Case
                else if(root == root.parent.right && root.parent == root.parent.parent.left){
                }
            }
        }
    }


    void rightRotate(Node x) {
        Node y = x.left;
        Node t2 = y.right;
        Node oldParent = x.parent;

        // Move T2
        x.left = t2;
        if (t2 != null) {
            t2.parent = x;
        }

        // Move y above x
        y.parent = oldParent;
        y.right = x;
        x.parent = y;

        // Connect y to the old parent or root
        if (oldParent == null) {
            root = y;
        } else if (oldParent.left == x) {
            oldParent.left = y;
        } else {
            oldParent.right = y;
        }
    }


    void leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;
        Node oldParent = x.parent;

        // Move T2
        x.right = t2;
        if (t2 != null) {
            t2.parent = x;
        }

        // Move y above x
        y.parent = oldParent;
        y.left = x;
        x.parent = y;

        // Connect y to the old parent or root
        if (oldParent == null) {
            root = y;
        } else if (oldParent.left == x) {
            oldParent.left = y;
        } else {
            oldParent.right = y;
        }
    }
}