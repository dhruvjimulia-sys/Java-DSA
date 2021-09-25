package binarysearchtree;

public class BST<T> {
    public TreeNode<T> root;
    public int numOfNodes;

    public BST(){
        this.numOfNodes = 0;
    };
    public BST(Comparable<T> rootValue) {
        this.root = new TreeNode<T>(rootValue);
        this.numOfNodes = 1;
    }

    public boolean isTreeEmpty() {
        return this.root == null;
    }

    public void insert(Comparable<T> nodeValue) {
        this.root.insert(new TreeNode<T>(nodeValue));
        this.numOfNodes++;
    }

    public void DFS(String type) {
        switch (type) {
            case "preorder":
                this.root.preOrderTraversal();
                break;

            case "postorder":
                this.root.postOrderTraversal();
                break;

            case "inorder":
                this.root.inOrderTraversal();
                break;
            
            default:
                throw new Error("Please input valild string for type of traversal");
        }
        System.out.println();
    }

    public void BFS() {
        CircularQueue queue = new CircularQueue(this.numOfNodes);
        queue.enqueue(this.root.val);
        this.root.BFS(queue);
        System.out.println();
    }

    public TreeNode<T> search(Comparable<T> nodeValue) {
        return this.root.search(nodeValue);
    }
}
