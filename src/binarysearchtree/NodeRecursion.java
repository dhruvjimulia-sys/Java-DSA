package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class NodeRecursion<T extends Comparable<T>> {
    public T value;
    public NodeRecursion<T> left;
    public NodeRecursion<T> right;

    public NodeRecursion(T value) {
        this.value = value;
    }

    public boolean add(T value) {
        if (this.value.compareTo(value) < 0) {
            if (this.right != null) {
                this.right.add(value);
            } else {
                this.right = new NodeRecursion<>(value);
            }
        } else if (this.value.compareTo(value) > 0) {
            if (this.left != null) {
                this.left.add(value);
            } else {
                this.left = new NodeRecursion<>(value);
            }
        } else {
            return false;
        }
        return true;
    }

    public List<T> preorder(List<T> list) {
        list.add(this.value);
        if (this.left != null) {
            this.left.preorder(list);
        }
        if (this.right != null) {
            this.right.preorder(list);
        }
        return list;
    }

    public List<T> inorder(List<T> list) {
        if (this.left != null) {
            this.left.inorder(list);
        }
        list.add(this.value);
        if (this.right != null) {
            this.right.inorder(list);
        }
        return list;
    }

    public List<T> postorder(List<T> list) {
        if (left != null) {
            left.postorder(list);
        }
        if (right != null) {
            right.postorder(list);
        }
        list.add(value);
        return list;
    }

    public List<T> bfs(Queue<T> queue, List<T> list) {
        if (this.left != null) {
            queue.enqueue(this.left.value);
        }
        if (this.right != null) {
            queue.enqueue(this.right.value);
        }
        list.add(queue.dequeue());
        if (!queue.isEmpty()) {
            if (this.left != null) {
                this.left.bfs(queue, list);
            }
            if (this.right != null) {
                this.right.bfs(queue, list);
            }
        }
        return list;
    }

    public boolean contains(Comparable<T> searchNode) {
        int comparison = searchNode.compareTo(this.value);
        if (comparison < 0 && this.left != null) {
            return this.left.contains(searchNode);
        } else if (comparison > 0 && this.right != null) {
            return this.right.contains(searchNode);
        } else {
            return comparison == 0;
        }
    }

    public String toString() {
        String toStringValue = "Value: " + this.value;
        if (this.left != null) {
            toStringValue += " Left: " + this.left.value;
        }
        if (this.right != null) {
            toStringValue += " Right: " + this.right.value;
        }
        return toStringValue;
    }

    public boolean remove(T value, NodeRecursion<T> parent,
        LinkedBSTRecursion<T> tree) {
        if (this.value.compareTo(value) == 0) {
            final List<NodeRecursion<T>> children = getNonNullChildren();
            if (children.size() == 0) {
                if (parent == null) {
                    tree.setRoot(null);
                    return true;
                }
                reparent(parent, this, null);
                return true;
            } else if (children.size() == 1) {
                if (parent == null) {
                    tree.setRoot(children.get(0));
                    return true;
                }
                reparent(parent, this, children.get(0));
                return true;
            } else {
                final Position<T> leftMostChild = right.findLeftMostChild(this);
                if (parent == null) {
                    tree.setRoot(leftMostChild.curr);
                }
                swapNodes(this, parent, leftMostChild.curr,
                    leftMostChild.parent);
                remove(value, leftMostChild.parent, tree);
                return true;
            }
        } else if (this.value.compareTo(value) < 0 && right != null) {
            return right.remove(value, this, tree);
        } else if (this.value.compareTo(value) > 0 && left != null) {
            return left.remove(value, this, tree);
        } else {
            return false;
        }
    }

    private Position<T> findLeftMostChild(NodeRecursion<T> parent) {
        if (this.left != null) {
            return left.findLeftMostChild(this);
        }
        return new Position<>(this, parent);
    }

    private void swapNodes(NodeRecursion<T> curr, NodeRecursion<T> parent,
        NodeRecursion<T> other, NodeRecursion<T> otherParent) {
        swapChildren(curr, other);
        if (other.right == other) {
            other.right = null;
        }
        otherParent.left = curr;
        if (parent != null) {
            reparent(parent, curr, other);
        }
    }

    private List<NodeRecursion<T>> getNonNullChildren() {
        final List<NodeRecursion<T>> list = new ArrayList<>();
        if (left != null) {
            list.add(left);
        }
        if (right != null) {
            list.add(right);
        }
        return list;
    }

    private void reparent(NodeRecursion<T> parent,
        NodeRecursion<T> child, NodeRecursion<T> newChild) {
        if (parent.right == child) {
            parent.right = newChild;
        } else {
            // parent.left == child
            parent.left = newChild;
        }
    }

    private void swapChildren(NodeRecursion<T> curr, NodeRecursion<T> other) {
        NodeRecursion<T> tempLeft = curr.left;
        NodeRecursion<T> tempRight = curr.right;
        curr.left = other.left;
        curr.right = other.right;
        other.left = tempLeft;
        other.right = tempRight;
    }

    private static class Position<T extends Comparable<T>> {
        public final NodeRecursion<T>  curr, parent;

        public Position(NodeRecursion<T> curr, NodeRecursion<T> parent) {
            this.parent = parent;
            this.curr = curr;
        }
    }
}