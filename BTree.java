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
            Node newRoot = newNode(order,false);

            newRoot.keys[0] = result.promotedKey;
            newRoot.children[0] = root;
            newRoot.children[1] = result.right;
            newRoot.n = 1;

            root = newRoot;
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

            if(childSplit!=null){
                for(int j = node.n - 1; j>=i; j--){
                    node.keys[j+1] = node.keys[j];
                }
                for(int j = node.n; j>=i+1; j--){
                    node.children[j+1] = node.children[j];
                }
                node.keys[i] = childSplit.promotedKey;
                node.children[i+1] = childSplit.right;
                node.n++;
            }
        }
        if(node.n == order){
            return splitNode(node);
        }
        return null;
    }

    Split splitNode(Node full){
        int median = full.n/2;
        int promotedKey = full.keys[median];

        Node right = new Node(order, full.leaf);

        right.n = full.n - median - 1;

        for(int j = 0; j<right.n; j++){
            right.keys[j] = full.keys[median + 1 + j];
        }
        if(!full.leaf){
            for(int j = 0; j<=right.n; j++){
                right.children[j] = full.children[median + 1 + j];
            }
        }
        full.n = median;

        return new Split(promotedKey, right);
    }
}