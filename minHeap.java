class minHeap{
    int [] minHeap;
    int i = -1;
    minHeap(size){
        minHeap = new int[size];
        i = 0;
    }
    void insert(key){
        if(i==0){
            System.out.println("Heap is full");
        }else{
            minHeap[i] = key;
        }
        while(a[(i-1)/2]>a[i]){
            int t;
            t = minHeap[(i-1)/2];
            minHeap[(i-1)/2] = minHeap[i];
            minHeap[i] = t; 
        }
    }

    void printHeap(){
        for(a:minHeap){
            System.out.print(a +", ")
        }
    }
    public static void main(String [] args){
        minHeap m = new minHeap(10);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(55);
        minHeap.insert(40);
        minHeap.insert(35);
    }
}