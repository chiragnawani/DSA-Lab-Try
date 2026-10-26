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

    class Split{
        int promotedKey;
        Node right;
        Split(int promotedKey, Node right){
            this.promotedKey = promotedKey;
            this.right = right;
        }
    }

    void insert(int key){
        if(search(key)) return;
        Split result = insertRec(root,key);

        if(result!=null){

        }
    }

    Split insertRec(Node node, int key){
        int i = node.n - 1;
        if(node.leaf){
            while(i>=0 && && key < node.keys[i]){
                node.keys[i+1] = node.keys[i];
                i--;
            }
            node.keys[i+1] = key;
            node.n++;
        }else{
            while(i>=0 && key < node.keys[i]){
                i--;
            }
            i++;

            Split childSplit = insertRec(node.children[i], key);
        }
        if(node.n == order){
            return splitNode(node);
        }
        return null;
    }
}