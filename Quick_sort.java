import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quick_sort {
    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        if(array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public static void main(String[] args) {
        int size = 800000;
        ArrayList<Integer> teste=new ArrayList<>();
        for(int i=0;i<8;i++){
            teste.add(i);
        }
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            input.add(i);
        }
        ArrayList<Integer> inputb = new ArrayList<>(input);
        inputb.sort(Collections.reverseOrder());
        ArrayList<Integer> inputc = new ArrayList<>(inputb);
        Collections.shuffle(inputc);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = inputc.get(i);
        }
        long ti = System.nanoTime();
        quicksort(arr);
        long tf = System.nanoTime();
        System.out.println(tf - ti);
    }
}
