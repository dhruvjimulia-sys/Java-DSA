package binarysearchtree;

public class BST<T> {
    public TreeNode<T> root;

    public BST(){};
    public BST(Comparable<T> rootValue) {
        this.root = new TreeNode<T>(rootValue);
    }

    public boolean isTreeEmpty() {
        return this.root == null;
    }

    public void insert(Comparable<T> nodeValue) {
        this.root.insert(new TreeNode<T>(nodeValue));
    }
}
