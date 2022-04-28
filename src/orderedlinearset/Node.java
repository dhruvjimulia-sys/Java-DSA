package orderedlinearset;

public class Node<T> {
  private T value;
  private int key;
  private Node<T> next;

  public Node(T value) {
    this(value, value.hashCode(), null);
  }

  public Node(T value, Node<T> next) {
    this(value, value.hashCode(), next);
  }

  public Node(T value, int key, Node<T> next) {
    this.value = value;
    this.key = key;
    this.next = next;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }
}
