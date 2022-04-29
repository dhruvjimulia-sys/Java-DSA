package binarysearchtree;

import java.util.List;

public interface BST<T> {
  boolean add(T value);
  boolean remove(T value);
  boolean contains(T value);

  List<T> preorder();
  List<T> inorder();
  List<T> postorder();
  List<T> bfs();
}
