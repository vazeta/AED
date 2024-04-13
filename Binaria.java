import java.util.*;

public class Binaria {
    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root=null;
    public void insert(int data) {
        if (root == null) {
           root=new Node(data);
           return;
        }
        Random random = new Random();
        Node atual = root;
        while (true) {
            if (random.nextBoolean()) {
                if (atual.left == null) {
                    atual.left = new Node(data);
                    return;
                } else {
                    atual = atual.left;
                }
            } else {
                if (atual.right == null) {
                    atual.right = new Node(data);
                    return;
                } else {
                    atual = atual.right;
                }
            }
        }
    }

    public boolean find(int data) {
        if (root == null) {
            return false;
        }
        Stack<Node> pilha = new Stack<>();
        pilha.push(root);
        while (!pilha.isEmpty()) {
            Node atual = pilha.pop();
            if (atual.data == data) {
                return true;
            }
            if (atual.right != null) {
                pilha.push(atual.right);
            }
            if (atual.left != null) {
                pilha.push(atual.left);
            }
        }
        return false;
    }

    public void printTree(Node node) {

        printTreeHelper(node, 0);
    }

    private void printTreeHelper(Node node, int level) {
        if (node != null) {
            printTreeHelper(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }
            System.out.println(node.data);
            printTreeHelper(node.left, level + 1);
        }
    }

    public static void main(String[] args) {
        int size = 1000000;
        ArrayList<Integer> teste=new ArrayList<>();
        for(int i=0;i<8;i++){
            teste.add(i);
        }
        ArrayList<Integer> input = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            input.add(i);
        }
        for (int j = (int)(0.9*size); j < size; j++) {
            int num = random.nextInt(size);
            input.set(j, num);
        }
        Collections.sort(input);
        ArrayList<Integer> inputb = new ArrayList<>(input);
        inputb.sort(Collections.reverseOrder());
        ArrayList<Integer> inputc = new ArrayList<>(inputb);
        Collections.shuffle(inputc);
        ArrayList<Integer> inputd = new ArrayList<>(input);
        int numDistinct = size / 10;
        for (int k = numDistinct; k < size; k++) {
            inputd.set(k, inputd.get(k % numDistinct));
        }
        Collections.shuffle(inputd);
        Binaria arvoreBinaria=new Binaria();
//        long ti=System.nanoTime();
//        for(int i=0;i<size;i++){
//            if(!arvoreBinaria.find(inputd.get(i))){
//                arvoreBinaria.insert(inputd.get(i));
//            }
//        }
        for(int i=0;i<8;i++){
            if(!arvoreBinaria.find(teste.get(i))){
                arvoreBinaria.insert(teste.get(i));
            }
        }
        arvoreBinaria.printTree(arvoreBinaria.root);
//        long tf=System.nanoTime();
//        System.out.println(tf-ti);
    }
}