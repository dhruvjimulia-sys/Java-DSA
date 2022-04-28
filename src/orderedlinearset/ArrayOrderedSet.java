package orderedlinearset;

import java.util.stream.IntStream;

public class ArrayOrderedSet<T extends Comparable<T>> implements OrderedSet<T> {
  public static final int DEFAULT_ARRAY_SIZE = 5;
  private int size;
  private int maxSize;
  private T[] elements;

  public ArrayOrderedSet() {
    this(DEFAULT_ARRAY_SIZE);
  }

  public ArrayOrderedSet(int maxSize) {
    elements = (T[]) new Comparable[maxSize];
    this.maxSize = maxSize;
  }

  @Override
  public boolean add(T item) {
    if (size >= maxSize) {
      T[] newElements = (T[]) new Comparable[maxSize * 2];
      maxSize *= 2;
      System.arraycopy(elements, 0, newElements, 0, size);
      elements = newElements;
    }
    for (int i = 0; i < size; i++) {
      if (item.compareTo(elements[i]) < 0) {
        shiftSubArrayRight(i);
        elements[i] = item;
        size++;
        return true;
      } else if (item.compareTo(elements[i]) == 0) {
        return false;
      }
    }
    elements[size] = item;
    size++;
    return true;
  }

  @Override
  public boolean remove(T item) {
    for (int i = 0; i < size; i++) {
      if (item.compareTo(elements[i]) == 0) {
        shiftSubArrayLeft(i);
        size--;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean contains(T item) {
    for (int i = 0; i < size; i++) {
      if (item.compareTo(elements[i]) == 0) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  private void shiftSubArrayLeft(int index) {
    IntStream.range(index, size).forEach(i -> elements[i] = elements[i + 1]);
  }

  private void shiftSubArrayRight(int index) {
    if (size + 1 - index >= 0) {
      System.arraycopy(elements, index, elements, index + 1, size + 1 - index);
    }
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(elements[i]);
      sb.append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    OrderedSet<Integer> set = new ArrayOrderedSet<>();
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
