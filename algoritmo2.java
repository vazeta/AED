import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class algoritmo2 {
    public static void main(String[] args) {
        double total = 0.0;
        int num=1000;
        for (int z = 0; z < num; z++) {
            int k;
            int size = 100000;
            Random random = new Random();
            k = random.nextInt(2 * size) + 1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(random.nextInt(size) + 1);
            }
            long tempoInicial = System.nanoTime();
            algoritmo2Funcao(arrayList, k, size);
            long tempoFinal = System.nanoTime();
            long tempoExecucao = tempoFinal - tempoInicial;
            double tempoExecucaoMilisegundos = (double) tempoExecucao / 1000000.0;
            total+=tempoExecucaoMilisegundos;
        }
        System.out.println("O tempo medio foi: " + (total/num) + " milisegundos");
    }
    public static boolean algoritmo2Funcao(ArrayList<Integer> arrayList, int k, int size) {
        Collections.sort(arrayList);
        int i = 0, j = size-1;
        while (i < j){
            int sum = arrayList.get(i) + arrayList.get(j);
            if ((sum == k) && (arrayList.get(i) != arrayList.get(j))) {
                return true;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
