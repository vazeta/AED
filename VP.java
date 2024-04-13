import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VP {
    public class Node {
        int data;
        Node left;
        Node right;
        char color;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.color = 'r';
        }
    }

    Node root = null;
    int rotationCount = 0;

    char getColor(Node node) {
        if (node != null) {
            return node.color;
        } else {
            return 'b';
        }
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            Node newNode = new Node(data);
            if (root == null) {
                newNode.color = 'b';
            }
            return newNode;
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        if (getColor(node.left) == 'r' && getColor(node.left.left) == 'r') {
            if (getColor(node.right) == 'b' || getColor(node.right) == ' ') {
                node = rotateRight(node);
                rotationCount++;
            } else {
                node.color = 'r';
                node.left.color = 'b';
                node.right.color = 'b';
            }
        } else if (getColor(node.left) == 'r' && getColor(node.left.right) == 'r') {
            if (getColor(node.right) == 'b' || getColor(node.right) == ' ') {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
                rotationCount++;
            } else {
                node.color = 'r';
                node.left.color = 'b';
                node.right.color = 'b';
            }
        } else if (getColor(node.right) == 'r' && getColor(node.right.left) == 'r') {
            if (getColor(node.left) == 'b' || getColor(node.left) == ' ') {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
                rotationCount++;
            } else {
                node.color = 'r';
                node.left.color = 'b';
                node.right.color = 'b';
            }
        } else if (getColor(node.right) == 'r' && getColor(node.right.right) == 'r') {
            if (getColor(node.left) == 'b' || getColor(node.left) == ' ') {
                node = rotateLeft(node);
                rotationCount++;
            } else {
                node.color = 'r';
                node.left.color = 'b';
                node.right.color = 'b';
            }

        }
        if (root == node) {
            node.color = 'b';
        }

        return node;
    }


    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        leftChild.color = 'b';
        node.color = 'r';
        return leftChild;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        rightChild.color = 'b';
        node.color = 'r';
        return rightChild;
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
            System.out.println(node.data + "(" + node.color + ")");
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
        VP arvoreVP = new VP();
//        long ti = System.nanoTime();
//        for(int i = 0; i < size; i++) {
//            arvoreVP.root = arvoreVP.insert(arvoreVP.root, inputc.get(i));
//        }
//        long tf = System.nanoTime();
//        System.out.println("Tempo de inserção: " + (tf - ti) + " nanossegundos");
        for(int i=0;i<8;i++){
            arvoreVP.root=arvoreVP.insert(arvoreVP.root, teste.get(i));
        }
        arvoreVP.printTree(arvoreVP.root);
        System.out.println("Número total de rotações durante a inserção: " + arvoreVP.rotationCount);
    }
}
