package stack;

public class LinkedStack<T> implements Stack<T> {
  private Node<T> head;

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public void push(T value) {
    head = new Node<>(value, head);
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new Error("Stack pop: Stack is empty");
    }
    T headValue = head.getValue();
    head = head.getNext();
    return headValue;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new Error("Stack pop: Stack is empty");
    }
    return head.getValue();
  }

  @Override
  public String toString() {
    Node<T> curr = head;
    final StringBuilder sb = new StringBuilder();
    while (curr != null) {
      sb.append(curr.getValue());
      sb.append(" ");
      curr = curr.getNext();
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new LinkedStack<>();
    // stack.peek();
    stack.push(3);
    stack.push(4);
    stack.push(2);
    stack.push(1);
    stack.push(9);
    stack.pop();
    System.out.println(stack.peek());
    System.out.println(stack);
  }
}
