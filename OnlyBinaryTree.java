import java.util.Scanner;
import java.util.Queue
class Node{
    int data;
    Node left,right;
    Node(int key){
        data = key;
        left = right = null
    }
}

class OnlyBinaryTree{
    Node root;
    void insert(int val){
        Node newNode = new Node(val);

        if(root == null){
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left == null){
                current.left = newNode;
                return
            }else{
                queue.add(current.left);
            }
            if(current.right == null){
                current.right = newNode;
                return
            }else{
                queue.add(current.right);
            }

        }
    }

    void levelTraverse(){
        Node current = queue.poll();
        System.out.print(current.data + " ");

        while(!queue.isEmpty()){
            if(current.left !=null){
                queue.add(current.left);
            }
            if(current.right !=null){
                queue.add(current.right);
            }
        }
    }
    Scanner sc = new Scanner(System.in);
    void build(){
        root = buildTree(root);
    }
    String ans;
    int key;
    void buildTree(Node root){
        if(root == null){
            System.out.print("Enter the node: ");
            key = sc.nextInt();
            root = new Node(key);
        }
        System.out.print("Does "+root.data + " has left child: ");
        String ans = sc.next();
        if(ans.equalsIgnoreCase("y")){
            root.left = buildTree(root.left);
        }
        System.out.print("Does "+root.data + " has right child: ");
        String ans = sc.next();
        if(ans.equalsIgnoreCase("y")){
        root.right = buildTree(root.right);
        }
    }



    void inOrder(){
        inOrderTraverse(root);
    }
    inOrderTraverse(Node root){
        if(root == null){
            return;
        }
        inOrderTraverse(root.left);
        System.out.println(root);
        inOrderTraverse(root.right);
    }

    public static void main (String [] args){
    OnlyBinaryTree b = new OnlyBinaryTree();
    b.build();
}

    
    
    
    
    
    
    
// class OnlyBinaryTree{
//     Scanner sc = new Scanner(System.in);
    // int capacity;
    // int a[];
    // OnlyBinaryTree(){
    //     System.out.print("Enter size of binary tree: ");
    //     capacity = sc.nextInt();
    //     a = new int[capacity];
    // }
    // void build(int i){
    //     if(i==0){
    //         System.out.print("Enter Root Node: ");
    //     }
    //     else if(i%2==1){
    //         System.out.print("Enter left child of "+a[(i-1)/2] + " : ");
    //     }
    //     else{
    //         System.out.print("Enter right child of "+a[(i-1)/2] + " : ");
    //     }

    //     a[i] = sc.nextInt();
    //     System.out.print("Does "+a[i] + " has left child: ");
    //     String ans = sc.next();
    //     if((ans.equalsIgnoreCase("y")) && (2*(i+1)-1<capacity)){
    //         build(2*(i+1)-1);
    //     }
    //     System.out.print("Does "+a[i] + " has right child: ");
    //     ans = sc.next();
    //     if((ans.equalsIgnoreCase("y")) && (2*(i+1)<capacity)){
    //         build(2*(i+1));
    //     }
    // }

    // void print(){
    //     int i = 0;
    //     while(i< a.length){
    //         System.out.print(a[i] + ", ");
    //         i++;
    //     }
    // }

    // void inOrder(int[i]){
    //     if(i>=capacity || a[i] == 0){
    //         return;
    //     }
    //     inOrder(2*(i+1)-1);
    //     System.out.print(a[i]+ ", ");
    //     inOrder(2*(i+1));
    // }

    // public static void main (String [] args){
    //     OnlyBinaryTree b = new OnlyBinaryTree();
    //     b.build(0);
    //     b.print();
    //     b.inOrder(0);
    // }
}