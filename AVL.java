import java.util.*;

public class AVL {
    public class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }
    Node root = null;
    int rotationCount = 0;
    public int height(Node node) {
        if (node != null) {
            return node.height;
        } else {
            return 0;
        }
    }
    public void updateHeight(Node node) {
        if (node != null) {
            int leftChildHeight = height(node.left);
            int rightChildHeight = height(node.right);
            node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
        }
    }
    public int balanceFactor(Node node) {
        if (node != null) {
            return height(node.left) - height(node.right);
        } else {
            return 0;
        }
    }
    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        updateHeight(node);
        return rebalance(node);
    }
    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        updateHeight(node);
        updateHeight(leftChild);
        return leftChild;
    }
    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        //aqui podia subsitiuir rightchild.left por null
        node.right = rightChild.left;
        rightChild.left = node;
        updateHeight(node);
        updateHeight(rightChild);
        return rightChild;
    }
    public Node rebalance(Node node) {
        updateHeight(node);
        int balanceFactor = balanceFactor(node);
        if (balanceFactor > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
            rotationCount++;
        }
        else if (balanceFactor < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
            rotationCount++;
        }

        return node;
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
        AVL avl = new AVL();
//        long ti = System.nanoTime();
//        for(int i = 0; i < size; i++) {
//            avl.root = avl.insert(avl.root, inputc.get(i));
//        }
//        long tf = System.nanoTime();
//        System.out.println("Tempo de inserção: " + (tf - ti) + " nanossegundos");
        for(int i=0;i<8;i++){
            avl.root=avl.insert(avl.root, teste.get(i));
        }
//        System.out.println("Número total de rotações durante a inserção: " + avl.rotationCount);
        avl.printTree(avl.root);
    }
}
