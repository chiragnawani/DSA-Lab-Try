class Node{
    int[] keys;
    Node[] children;
    int n;

    Node(int order){
        keys = new int[order];
        children = new Node[order + 1];
        n = 0;
    }
}

class BTree{
    
}