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
        return root;
    }

    void fixInsert(Node newNode){
        while(newNode != root and newNode.parent.color == "R"){
            Node p = newNode.parent
            Node gp = p.parent;
            Node u;
            if(p == gp.left){
                u = gp.right;
                // CASE 1: Uncle is Red
                if(u !=null && u.color == "R"){
                    p.color = u.color = "B";
                    gp.color = "R"

                    newNode = gp;
                }
                else{
                    if(newNode == p.right){
                        newNode = p;
                        p = leftRotate(p);

                        p = newNode.parent;
                        gp = p.parent;
                    }
                    p.color = "B";
                    gp.color = "R";
                    gp = rightRotate(gp);
                }
            }
            else{
                u=gp.left;
                if(u !=null && u.color == "R"){
                    p.color = u.color = "B";
                    gp.color = "R"

                    newNode = gp;
                }else{
                    if(newNode == p.left){
                        newNode = p;
                        p = rightRotate(p);
                        p = newNode.parent;
                        gp = p.parent;
                    }
                    p.color = "B";
                    gp.color = "R";
                    gp = leftRotate(gp);
                }
            }
        }
        root.color = "B";
    }


    //Deletion
    Node search(int n) {
        Node temp = root;
        while (temp != null) {
            if (n < temp.val) {
                if (temp.left == null)
                    break;
                else
                    temp = temp.left;
            } else if (n == temp.val) {
                break;
            } else {
                if (temp.right == null)
                    break;
                else
                    temp = temp.right;
            }
        }

        return temp;
    }
    void delete(int val){
        if(root == null){
            return;
        }
        Node v = search(val);
        if(v.data ! = val){
            System.out.println("No node found to delete with value: " + n);
            return;
        }
        deleteNode(v);
    }

    void deleteNode(Node root){
        root = null;
    }

    Node rightRotate(Node gp) {
        Node p = gp.left;
        Node y = p.right;
        Node oldParent = gp.parent;

        // Connect p to the old parent
        p.parent = oldParent;

        if (oldParent != null) {
            if (oldParent.left == gp) {
                oldParent.left = p;
            } else {
                oldParent.right = p;
            }
        }

        // Perform rotation
        p.right = gp;
        gp.parent = p;

        gp.left = y;

        if (y != null) {
            y.parent = gp;
        }

        return p;
    }


    Node leftRotate(Node gp){
        Node oldParent = gp.parent;
        Node p = gp.right;
        Node y = p.left;

        p.parent = oldParent;
        if (oldParent != null) {
            if (oldParent.left == gp) {
                oldParent.left = p;
            } else {
                oldParent.right = p;
            }
        }

        p.left = gp;
        gp.parent = p;

        gp.right = y;
        if(y!=null){
            y.parent = gp;
        }

        return p;
    }
}