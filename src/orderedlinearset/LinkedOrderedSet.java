package orderedlinearset;

public class LinkedOrderedSet<T> implements OrderedSet<T> {
  int size = 0;
  private Node<T> head, tail;

  public LinkedOrderedSet() {
    head = new Node<>(null, Integer.MIN_VALUE, null);
    tail = new Node<>(null, Integer.MAX_VALUE, null);
    head.setNext(tail);
  }

  private Position<T> find(Node<T> start, int key) {
    Node<T> pred = null;
    Node<T> curr = start;
    do {
      pred = curr;
      curr = curr.getNext();
    } while (curr.getKey() < key);  // until curr.key >= key
    return new Position<T>(pred, curr);
  }

  @Override
  public boolean add(T item) {
    final Node<T> node = new Node<>(item);
    final Position<T> where = find(head, node.getKey());
    if (where.curr.getKey() == node.getKey()) {
      return false;
    } else {
      node.setNext(where.curr);
      where.pred.setNext(node);
      size += 1;
      return true;
    }
  }

  @Override
  public boolean remove(T item) {
    final Node<T> node = new Node<>(item);
    final Position<T> where = find(head, node.getKey());
    if (where.curr.getKey() == node.getKey()) {
      where.pred.setNext(where.curr.getNext());
      size--;
      return true;
    }
    return false;
  }

  @Override
  public boolean contains(T item) {
    final Node<T> node = new Node<>(item);
    final Position<T> where = find(head, node.getKey());
    return where.curr.getKey() == node.getKey();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    Node<T> curr = head.getNext();
    final StringBuilder sb = new StringBuilder();
    while (curr.getKey() != Integer.MAX_VALUE) {
      sb.append(curr.getValue());
      sb.append(" ");
      curr = curr.getNext();
    }
    return sb.toString();
  }

  private static class Position<T> {
    public final Node<T> pred, curr;

    public Position(Node<T> pred, Node<T> curr) {
      this.pred = pred;
      this.curr = curr;
    }
  }

  public static void main(String[] args) {
    OrderedSet<Integer> set = new LinkedOrderedSet<>();
    set.add(2);
    set.add(2);
    set.add(1);
    set.add(4);
    set.add(9);
    set.remove(9);
    System.out.println(set.contains(1));
    System.out.println(set.contains(9));
    System.out.println(set);
  }
}
