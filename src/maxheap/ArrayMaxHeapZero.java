package maxheap;

public class ArrayMaxHeapZero<T extends Comparable<T>> implements MaxHeap<T> {
  private T[] elements;
  private int size;
  private int maxSize;
  public static final int DEFAULT_MAX_SIZE = 20;

  public ArrayMaxHeapZero() {
    this(DEFAULT_MAX_SIZE);
  }

  public ArrayMaxHeapZero(int maxSize) {
    this.maxSize = maxSize;
    elements = (T[]) new Comparable[maxSize];
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
  public void add(T value) {
    if (size + 1 >= maxSize) {
      T[] newElements = (T[]) new Comparable[maxSize * 2];
      System.arraycopy(elements, 0, newElements, 0, size);
      elements = newElements;
      maxSize *= 2;
    }
    size++;
    elements[size - 1] = value;
    percolateup(size - 1);
  }

  private void percolateup(int c) {
    if (c > 0) {
      int parent = (c - 1) / 2;
      if (elements[c].compareTo(elements[parent]) > 0) {
        swap(c, parent);
        percolateup(parent);
      }
    }
  }

  @Override
  public T getMax() {
    return isEmpty() ? null : elements[0];
  }

  @Override
  public T removeMax() {
    if (isEmpty()) {
      return null;
    }
    swap(0, size - 1);
    size--;
    fixMaxHeap(0);
    return elements[size];
  }

  private void swap(int index, int index2) {
    final T temp = elements[index];
    elements[index] = elements[index2];
    elements[index2] = temp;
  }

  private void fixMaxHeap(int root) {
    int left = 2 * root + 1;
    int right = 2 * root + 2;
    if (left <= size - 1) {
      int largerSubHeap;
      if (left == size - 1) {
        largerSubHeap = left;
      } else if (elements[left].compareTo(elements[right]) > 0) {
        largerSubHeap = left;
      } else {
        largerSubHeap = right;
      }
      if (elements[root].compareTo(elements[largerSubHeap]) < 0) {
        swap(root, largerSubHeap);
        fixMaxHeap(largerSubHeap);
      }
    }
  }

  public String toString() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(elements[i]);
      sb.append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    MaxHeap<Integer> heap = new ArrayMaxHeapZero<>();

    heap.add(3);
    heap.add(9);
    heap.add(5);
    heap.add(2);
    heap.add(10);

    System.out.println(heap.removeMax());
    System.out.println(heap.removeMax());
    System.out.println(heap.removeMax());

    System.out.println(heap);
  }
}