class BTree{
    class Node{
        int[] keys;
        Node[] children;
        int n;
        boolean leaf;

        Node(int order, boolean isLeaf){
            keys = new int[order];
            children = new Node[order + 1];
            n = 0;
            this.leaf = leaf;
        }
    }

    int order;
    Node root;

    BTree(int order){
        if(order<3){
            throw new IllegalArgumentException("Order must be >= 3");
        }
        this.order = order;
        root = new Node(order,true);
    }

    void insert(int key){
        if(search(key)) return;
        Split result = 
    }
}