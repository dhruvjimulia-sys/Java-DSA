package list;

import java.util.Iterator;

public class LinkedListIterator<T> implements List<T>, Iterable<T> {
  private Node<T> head;
  private int size;

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> curr = null;

      @Override
      public boolean hasNext() {
        return curr == null || curr.getNext() != null;
      }

      @Override
      public T next() {
        if (curr == null) {
          curr = head;
        } else {
          curr = curr.getNext();
        }
        return curr.getValue();
      }
    };
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get(int index) {
    Node<T> curr = head;
    int counter = 0;
    while (curr != null) {
      if (index == counter) {
        return curr.getValue();
      }
      curr = curr.getNext();
      counter++;
    }
    throw new IndexOutOfBoundsException("LinkedListIterator get " + index);
  }

  @Override
  public void addAfter(int index, T value) {
    Node<T> curr = head;
    int counter = 0;
    final Node<T> newNode = new Node<>(value);
    while (curr != null) {
      if (counter == index) {
        newNode.setNext(curr.getNext());
        curr.setNext(newNode);
        size++;
        return;
      }
      curr = curr.getNext();
    }
    throw new IndexOutOfBoundsException("LinkedListIterator add " + index);
  }

  @Override
  public void addBefore(int index, T value) {
    if (index == 0) {
      head = new Node<>(value, head);
      size++;
      return;
    }

    Node<T> curr = head;
    final Node<T> newNode = new Node<>(value);
    int counter = 0;
    while (curr != null) {
      if (counter + 1 == index) {
        newNode.setNext(curr.getNext());
        curr.setNext(newNode);
        size++;
        return;
      }
      counter++;
      curr = curr.getNext();
    }
    throw new IndexOutOfBoundsException("LinkedListIterator addBefore " + index);
  }

  @Override
  public T remove(int index) {
    if (head == null) {
      throw new IndexOutOfBoundsException(
          "LinkedListIterator: removing from empty list"
      );
    }
    if (index == 0) {
      final T oldHeadValue = head.getValue();
      head = head.getNext();
      size--;
      return oldHeadValue;
    }
    Node<T> prev = head;
    Node<T> curr = head.getNext();
    int counter = 1;
    while (curr != null) {
      if (counter == index) {
        prev.setNext(curr.getNext());
        size--;
        return curr.getValue();
      }
      counter++;
      curr = curr.getNext();
    }
    throw new IndexOutOfBoundsException("LinkedListIterator remove " + index);
  }

  @Override
  public void update(int index, T value) {
    Node<T> curr = head;
    int counter = 0;
    while (curr != null) {
      if (counter == index) {
        curr.setValue(value);
        return;
      }
      counter++;
      curr = curr.getNext();
    }
    throw new IndexOutOfBoundsException("LinkedListIterator update " + index);
  }

  @Override
  public boolean contains(T value) {
    Node<T> curr = head;
    while (curr != null) {
      if (curr.getValue().equals(value)) {
        return true;
      }
      curr = curr.getNext();
    }
    return false;
  }

  @Override
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
    final LinkedListIterator<Integer> list = new LinkedListIterator<>();
    list.addBefore(0, 2);
    list.addBefore(0, 4);
    list.addBefore(0, 5);      // 5, 4, 2
    list.addBefore(0, 10);     // 10, 5, 4, 2
    list.addBefore(1, 200);    // 10, 200, 5, 4, 2
    list.remove(0);                 // 200, 5, 4, 2
    list.update(2, 10);       // 200, 5, 10, 2
    System.out.println(list);
    System.out.println(list.size());

    for (Integer i : list) {
      System.out.print(i);
      System.out.print(" ");
    }
  }
}
