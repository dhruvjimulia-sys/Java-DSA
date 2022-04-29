package binarysearchtree;

public interface Queue<T> {
  boolean isEmpty();
  void enqueue(T value);
  T dequeue();
}