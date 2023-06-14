package homework2;

public class HeapSort {
    public static void main(String[] args) {
        int [] numbers = new int []{
                5,4,6,7,2,1,9,0,3,8
        };
        heapSort(numbers);
        for (Integer num: numbers) {
            System.out.printf("%d ", num);
        }
    }

    /**
     * @apiNote Пирамидальная сортировка массива
     * @param array
     */
    public static void heapSort(int[] array) {
        for (int i = array.length/2 - 1; i >= 0 ; i--)
            heapfy(array,array.length, i);

        for (int i = array.length - 1; i >= 0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapfy(array, i, 0);
        }
    }

    /**
     * @apiNote Просеивание кучи
     * @param array
     * @param heapSize
     * @param parent
     */
    public static void heapfy (int [] array, int heapSize, int parent){
        int largest = parent;
        int leftChild = 2*parent + 1;
        int rightChild = 2*parent + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        if (largest != parent){
            int temp = array[parent];
            array[parent] = array[largest];
            array[largest] = temp;

            heapfy(array, heapSize, largest);
        }
    }
}