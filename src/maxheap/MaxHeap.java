package maxheap;

public interface MaxHeap<T> {
  boolean isEmpty();
  int size();
  void add(T value);
  T getMax();
  T removeMax();
}
