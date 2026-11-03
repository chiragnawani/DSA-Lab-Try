public class MinHeap {

    static int[] heap = new int[100];
    static int size = 0;

    public static void insert(int value) {

        int i = size;

        heap[i] = value;
        size++;

        while (i > 0) {

            int parent = (i - 1) / 2;

            if (heap[i] < heap[parent]) {

                int temp = heap[i];
                heap[i] = heap[parent];
                heap[parent] = temp;

                i = parent;

            } else {
                break;
            }
        }
    }

    public static void delete(int key){
        if(size == 0){
            System.out.println("Heap is Empty");
        }
        int min = heap[0];
        heap[0] = heap[size-1];
        size--;

        heapifyDown(0);
    }
    public static void heapifyDown(int i){
        while(true){
            int left = 2*(i+1)-1;
            int right = 2*(i+1);

            int smallest = i;

            if(left<size && heap[left]<heap[smallest]){
                smallest = left;
            }

            if(right<size && heap[right]<heap[smallest]){
                smallest = right;
            }

            if(smallest!=i){
                int temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;

                i = smallest;
            }else{
                break;
            }
        }
    }
    public static void display() {

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        insert(10);
        insert(20);
        insert(15);
        insert(40);
        insert(30);
        insert(5);

        display();
    }
}