import java.util.ArrayList;
import java.util.Collections;

public class Insertion_sort {
    public static void insertionSort(ArrayList<Integer> array, int size) {
        for (int i = 1; i < size; ++i) {
            int value = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > value) {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }
            array.set(j + 1, value);
        }
    }

    public static void main(String[] args) {
        int size = 200000;
        ArrayList<Integer> teste=new ArrayList<>();
        for(int i=0;i<8;i++){
            teste.add(i);
        }
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            input.add(i);
        }
        Collections.sort(input);
        ArrayList<Integer> inputb = new ArrayList<>(input);
        inputb.sort(Collections.reverseOrder());
        ArrayList<Integer> inputc = new ArrayList<>(inputb);
        Collections.shuffle(inputc);
        long ti=System.nanoTime();
        insertionSort(inputb, size);
        long tf=System.nanoTime();
        System.out.println((tf-ti));
    }

}
