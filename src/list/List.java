package list;

public interface List<T> {
  boolean isEmpty();
  int size();
  T get(int index);
  void addAfter(int index, T value);
  void addBefore(int index, T value);
  T remove(int index);
  void update(int index, T value);
  boolean contains(T value);
  void displayList();
}
