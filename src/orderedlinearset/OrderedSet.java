package orderedlinearset;

public interface OrderedSet<T> {
  boolean add(T item);

  boolean remove(T item);

  boolean contains(T item);

  int size();
}
