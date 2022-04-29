package maxheap;

public class ArrayMaxHeapOne<T extends Comparable<T>> implements MaxHeap<T> {
  private T[] elements;
  private int size;
  private int maxSize;
  public static final int DEFAULT_MAX_SIZE = 20;

  public ArrayMaxHeapOne() {
    this(DEFAULT_MAX_SIZE);
  }

  public ArrayMaxHeapOne(int maxSize) {
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
    elements[size] = value;
    percolateup(size);
  }

  private void percolateup(int c) {
    if (c > 1) {
      int parent = c / 2;
      if (elements[c].compareTo(elements[parent]) > 0) {
        swap(c, parent);
        percolateup(parent);
      }
    }
  }

  @Override
  public T getMax() {
    return isEmpty() ? null : elements[1];
  }

  @Override
  public T removeMax() {
    if (isEmpty()) {
      return null;
    }
    swap(1, size);
    size--;
    fixMaxHeap(1);
    return elements[size + 1];
  }

  private void swap(int index, int index2) {
    final T temp = elements[index];
    elements[index] = elements[index2];
    elements[index2] = temp;
  }

  private void fixMaxHeap(int root) {
    int left = 2 * root;
    int right = 2 * root + 1;
    if (left <= size) {
      int largerSubHeap;
      if (left == size) {
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
    for (int i = 0; i < size + 1; i++) {
      sb.append(elements[i]);
      sb.append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    MaxHeap<Integer> heap = new ArrayMaxHeapOne<>();

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
