import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Heap_sort {
    public static void heapSort(ArrayList<Integer> array) {
        int n = array.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
        for (int i = n - 1; i > 0; i--) {
            Collections.swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    public static void heapify(ArrayList<Integer> array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array.get(left) > array.get(largest))
            largest = left;

        if (right < n && array.get(right) > array.get(largest))
            largest = right;

        if (largest != i) {
            Collections.swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int size = 200000;
        ArrayList<Integer> teste=new ArrayList<>();
        for(int i=0;i<8;i++){
            teste.add(i);
        }
        ArrayList<Integer> input = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            input.add(i);
        }
        Collections.sort(input);
        ArrayList<Integer> inputb = new ArrayList<>(input);
        inputb.sort(Collections.reverseOrder());
        ArrayList<Integer> inputc = new ArrayList<>(inputb);
        Collections.shuffle(inputc);
        long ti=System.nanoTime();
        heapSort(inputb);
        long tf=System.nanoTime();
        System.out.println((tf-ti));
    }
}