package list;

import java.util.stream.IntStream;

public class ArrayList<T> implements List<T> {
  public static final int DEFAULT_INITIAL_SIZE = 100;
  private int size;
  private int totalSize = 0;
  private T[] elements;

  public ArrayList(int totalSize) {
    elements = (T[]) new Object[totalSize];
    this.totalSize = totalSize;
  }

  public ArrayList() {
    this(DEFAULT_INITIAL_SIZE);
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
    if (index > 0 && index < size) {
      return elements[index];
    } else {
      throw new IndexOutOfBoundsException("LinkedListArray get at " + index);
    }
  }

  @Override
  public void addAfter(int index, T value) {
    growArrayIfRequired();
    addBefore(index + 1, value);
  }

  @Override
  public void addBefore(int index, T value) {
    growArrayIfRequired();
    if (index >= 0 && index <= size) {
      shiftSubArrayRight(index);
      elements[index] = value;
      size++;
    }
  }

  private void growArrayIfRequired() {
    if (size >= elements.length) {
      T[] newElements = (T[]) new Object[totalSize * 2];
      System.arraycopy(elements, 0, newElements, 0, size);
      elements = newElements;
    }
  }

  @Override
  public T remove(int index) {
    if (index >= 0 && index < size) {
      final T oldElement = elements[index];
      shiftSubArrayLeft(index);
      size--;
      return oldElement;
    }
    throw new IndexOutOfBoundsException("LinkedList remove at " + index);
  }

  @Override
  public void update(int index, T value) {
    if (index >= 0 && index < size) {
      elements[index] = value;
    } else {
      throw new IndexOutOfBoundsException("LinkedListArray update at " + index);
    }
  }

  @Override
  public boolean contains(T value) {
    for (int i = 0; i < size; i++) {
      if (elements[i].equals(value)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void displayList() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(elements[i]);
      sb.append(" ");
    }
    System.out.println(sb);
  }

  private void shiftSubArrayLeft(int index) {
    IntStream.range(index, size).forEach(i -> {
      elements[i] = elements[i + 1];
    });
  }

  private void shiftSubArrayRight(int index) {
    for (int i = size + 1; i > index; i--) {
      elements[i] = elements[i - 1];
    }
  }

  public static void main(String[] args) {
    final List<Integer> list = new ArrayList<>();
    list.addBefore(0, 2);
    list.addBefore(0, 4);
    list.addBefore(0, 5);      // 5, 4, 2
    list.addBefore(0, 10);     // 10, 5, 4, 2
    list.addBefore(1, 200);    // 10, 200, 5, 4, 2
    list.remove(0);                 // 200, 5, 4, 2
    list.update(2, 10);       // 200, 5, 10, 2
    list.displayList();
    System.out.println(list.size());

    final Integer[] array = {2, 3, 4, 5};
    final LinkedList<Integer> list2 = new LinkedList<>(array);
    list2.displayList();
    System.out.println(list2.size());
  }
}
