package binarysearchtree;

public class TreeNode<T> {
    public Comparable<T> val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {}
    public TreeNode(Comparable<T> val) {
        this.val = val;
    }

    @SuppressWarnings("unchecked") // Assumes that both values are of same type
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
}
