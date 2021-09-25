package binarysearchtree;

public class App {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>(5);

        bst.insert(3);
        bst.insert(10);
        bst.insert(9);
        bst.insert(2);
        bst.insert(4);
        bst.insert(8);

        System.out.println(bst.root.val);
        System.out.println(bst.root.right.val);
        System.out.println(bst.root.left.val);
    }
}
