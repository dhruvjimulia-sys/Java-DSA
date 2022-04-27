package queue;

public class LinkedQueue<T> implements Queue<T> {
  private Node<T> head;

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public void enqueue(T value) {
    head = new Node<>(value, head);
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new Error("Cannot dequeue: Queue is empty");
    }
    Node<T> prev = head;
    Node<T> curr = prev.getNext();

    while (curr.getNext() != null) {
      prev = prev.getNext();
      curr = curr.getNext();
    }

    prev.setNext(null);
    return curr.getValue();
  }

  public String toString() {
    final StringBuilder sb = new StringBuilder();
    Node<T> curr = head;
    while (curr != null) {
      sb.append(curr.getValue());
      sb.append(" ");
      curr = curr.getNext();
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedQueue<>();
    queue.enqueue(2);
    queue.enqueue(3);
    queue.dequeue();
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    // Following code does not result in error because of circular buffer
    queue.enqueue(6);
    System.out.println(queue);
  }
}
