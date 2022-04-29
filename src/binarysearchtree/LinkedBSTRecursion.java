package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class LinkedBSTRecursion<T extends Comparable<T>> implements BST<T> {
    private NodeRecursion<T> root;
    private int numOfNodes;

    public LinkedBSTRecursion(){}

    public LinkedBSTRecursion(T value) {
        root = new NodeRecursion<>(value);
        numOfNodes = 1;
    }

    @Override
    public boolean add(T value) {
        if (root != null) {
            final boolean added = root.add(value);
            if (added) {
                numOfNodes++;
            }
            return added;
        }
        root = new NodeRecursion<>(value);
        numOfNodes++;
        return true;
    }

    @Override
    public boolean remove(T value) {
        if (root == null) {
            return false;
        }
        final boolean removed = root.remove(value, null, this);
        if (removed) {
            numOfNodes--;
        }
        return removed;
    }

    @Override
    public boolean contains(T value) {
        if (root == null) {
            return false;
        }
        return root.contains(value);
    }

    @Override
    public List<T> preorder() {
        if (root == null) {
            return new ArrayList<>();
        }
        return root.preorder(new ArrayList<>());
    }

    @Override
    public List<T> postorder() {
        if (root == null) {
            return new ArrayList<>();
        }
        return root.postorder(new ArrayList<>());
    }

    @Override
    public List<T> inorder() {
        if (root == null) {
            return new ArrayList<>();
        }
        return root.inorder(new ArrayList<>());
    }

    @Override
    public List<T> bfs() {
        if (root == null) {
            return new ArrayList<>();
        }
        final Queue<T> queue = new QueueArrayCircularBuffer<>(numOfNodes);
        queue.enqueue(this.root.value);
        return root.bfs(queue, new ArrayList<>());
    }

    void setRoot(NodeRecursion<T> root) {
        this.root = root;
    }

    public static void main(String[] args) {
        final BST<Integer> bst = new LinkedBSTRecursion<>();

        bst.add(5);
        bst.add(3);
        bst.add(10);
        bst.add(9);
        bst.add(2);
        bst.add(4);
        bst.add(8);
        bst.add(13);
        bst.add(12);

        System.out.println(bst.remove(5));

        System.out.println(bst.preorder());
        System.out.println(bst.postorder());
        System.out.println(bst.inorder());
        System.out.println(bst.bfs());
        System.out.println(bst.contains(3));
    }
}
