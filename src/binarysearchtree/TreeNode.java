package binarysearchtree;

public class TreeNode<T> {
    public Comparable<T> val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {}
    public TreeNode(Comparable<T> val) {
        this.val = val;
    }

    @SuppressWarnings("unchecked") // Assumes that all values are of same type during downcast from Comparable<T> to <T>
    public void insert(TreeNode<T> value) {
        if (this.val.compareTo((T) value.val) < 0) {
            if (this.right != null) {
                this.right.insert(value);
            } else {
                this.right = value;
            }
        } else {
            if (this.left != null) {
                this.left.insert(value);
            } else {
                this.left = value;
            }
        }
    }

    // Root, Left, Right
    public void preOrderTraversal() {
        System.out.print(this.val + " ");
        if (this.left != null) {
            this.left.preOrderTraversal();
        }
        if (this.right != null) {
            this.right.preOrderTraversal();
        }
    }

    // Left, Root, Right
    public void inOrderTraversal() {
        if (this.left != null) {
            this.left.inOrderTraversal();
        }
        System.out.print(this.val + " ");
        if (this.right != null) {
            this.right.inOrderTraversal();
        }
    }

    // Left, Right, Root
    public void postOrderTraversal() {
        if (this.left != null) {
            this.left.postOrderTraversal();
        }
        if (this.right != null) {
            this.right.postOrderTraversal();
        }
        System.out.print(this.val + " ");
    }

    public void BFS(CircularQueue queue) {
        if (this.left != null) {
            queue.enqueue(this.left.val);
        }

        if (this.right != null) {
            queue.enqueue(this.right.val);
        }

        System.out.print(queue.dequeue() + " ");

        if (!queue.isEmpty()) {
            if (this.left != null) {
                this.left.BFS(queue);
            }

            if (this.right != null) {
                this.right.BFS(queue);
            }
        }
    }

    @SuppressWarnings("unchecked") // Assumes that all values are of same type (during downcast from Comparable<T> to <T>)
    public TreeNode<T> search(Comparable<T> searchNode) {
        int comparison = searchNode.compareTo((T) this.val);
        if (comparison < 0 && this.left != null) {
            return this.left.search(searchNode);
        } else if (comparison > 0 && this.right != null) {
            return this.right.search(searchNode);
        } else {
            // System.out.println(this);
            return this;
        }
    }

    public String toString() {
        String toStringValue = "Value: " + this.val;
        if (this.left != null) {
            toStringValue += " Left: " + this.left.val;
        }
        if (this.right != null) {
            toStringValue += " Right: " + this.right.val;
        }
        return toStringValue;
    }
}