package queue;

public interface Queue<T> {
  boolean isEmpty();
  void enqueue(T value);
  T dequeue();
}
