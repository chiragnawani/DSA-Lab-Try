import java.util.Scanner;
class OnlyBinaryTree{
    Scanner sc = new Scanner(System.in);
    int capacity;
    int a[];
    OnlyBinaryTree(){
        System.out.print("Enter size of binary tree: ");
        capacity = sc.nextInt();
        a = new int[capacity];
    }
    void build(int i){
        if(i==0) System.out.print("Enter Root Node: ");
        else if(i%2==1){
            System.out.print("Enter left child of "+a[(i-1)/2] + " : ");
        }
        else{
            System.out.print("Enter right child of "+a[(i-1)/2] + " : ");
        }
        a[i] = sc.nextInt();
        System.out.print("Does "+a[i] + " has left child: ");
        String ans = sc.next();
        if((ans == "y" || ans == "Y") && (2*(i+1)-1<a[capacity])){
            build(2*(i+1)-1);
        }
        System.out.print("Does "+a[i] + " has left child: ");
        ans = sc.next();
        if((ans == "y" || ans == "Y") && (2*(i+1)<a[capacity])){
            build(2*(i+1));
        }
    }

    void print(){
        int i = 0;
        while(i< a.length){
            System.out.print(a[i] + ", ");
            i++;
        }
    }

    public static void main (String [] args){
        OnlyBinaryTree b = new OnlyBinaryTree();
        b.build(0);
        b.print();
    }
}