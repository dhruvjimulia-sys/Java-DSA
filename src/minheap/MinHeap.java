package minheap;

public interface MinHeap<T> {
  boolean isEmpty();
  int size();
  void add(T value);
  T getMin();
  T removeMin();
}
