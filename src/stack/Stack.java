package stack;

public interface Stack<T> {
  boolean isEmpty();
  void push(T value);
  T pop();
  T peek();
}
