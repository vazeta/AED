import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class algoritmo3 {
    public static void main(String[] args) {
        double total = 0.0;
        int num = 1000;
        for (int z = 0; z < num; z++) {
            int k;
            int size = 100000;
            ArrayList<Integer> arrayList = new ArrayList<>();
            Random random = new Random();
            k = random.nextInt(2 * size) + 1;
            for (int i = 0; i < size; i++) {
                arrayList.add(random.nextInt(size) + 1);
            }
            long tempoInicial = System.nanoTime();
            algoritmo3Funcao(arrayList, k, size);
            long tempoFinal = System.nanoTime();
            long tempoExecucao = tempoFinal - tempoInicial;
            double tempoExecucaoMilisegundos = (double) tempoExecucao / 1000000.0;
            total += tempoExecucaoMilisegundos;
        }
        System.out.println("O tempo médio foi: " + (total/num) + " milisegundos");
    }
    public static boolean algoritmo3Funcao(ArrayList<Integer> arrayList, int k,int size) {
        int[] c = new int[size*2];
        Arrays.fill(c, 0);
        int aux;
        for(Integer num:arrayList){
            if(num<k && c[num]!=1){
                c[num]=1;
                aux=k-num;
                if(arrayList.contains(aux) && aux!=num){
                    return true;
                }
            }
        }
        return false;
    }
}

