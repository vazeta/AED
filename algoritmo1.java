import java.util.ArrayList;
import java.util.Random;

public class algoritmo1 {
    public static void main(String[] args) {
        double total=0.0;
        int num=1000;
        for (int z = 0; z < num; z++) {
            int size = 100000;
            Random random = new Random();
            int k;
            k = random.nextInt(2 * size) + 1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(random.nextInt(size) + 1);
            }
            long tempoInicial = System.nanoTime();
            algoritmo1Funcao(arrayList, k);
            long tempoFinal = System.nanoTime();
            long tempoExecucao = tempoFinal - tempoInicial;
            double tempoExecucaoMilisegundos = (double) tempoExecucao / 1000000.0;
            total+=tempoExecucaoMilisegundos;
        }
        System.out.println("O tempo medio foi: " + (total/num) + " milisegundos");
    }
    public static boolean algoritmo1Funcao(ArrayList<Integer> arrayList, int k) {
        boolean resultado=false;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i; j < arrayList.size(); j++) {
                if (((arrayList.get(i) + arrayList.get(j)) == k) && (arrayList.get(i) != arrayList.get(j))) {
                    resultado=true;
                }
            }
        }
        return resultado;
    }
}
