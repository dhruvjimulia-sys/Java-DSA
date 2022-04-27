package list;

import javax.swing.plaf.synth.SynthDesktopIconUI;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public LinkedList(T[] arr) {
        if (arr.length == 1) {
            this.head = new Node<>(arr[0]);
        } else if (arr.length > 1) {
            Node<T> curr = null;
            Node<T> next = new Node<>(arr[arr.length - 1]);
            for (int i = arr.length - 2; i >= 0; i--) {
                curr = new Node<>(arr[i], next);
                next = curr;
            }
            this.head = curr;
        }
        size = arr.length;
    }

    public T get(int index) {
        Node<T> curr = head;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.getValue();
            }
            i++;
            curr = curr.getNext();
        }
        throw new IndexOutOfBoundsException("LinkedList: get " + index);
    }

    public void addAfter(int index, T value) {
        Node<T> curr = this.head;
        int counter = 0;

        while (curr != null) {
            if (counter == index) {
                Node<T> newNode = new Node<>(value, curr.getNext());
                curr.setNext(newNode);
                size++;
                return;
            }
            curr = curr.getNext();
            counter++;
        }
        throw new IndexOutOfBoundsException("LinkedList insert at " + index);
    }

    public void addBefore(int index, T value) {
        if (index == 0) {
            this.head = new Node<>(value, this.head);
            size++;
            return;
        }
        Node<T> curr = this.head;
        Node<T> newNode = new Node<>(value);
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
    }

    public T remove(int index) {
        Node<T> curr = this.head;
        Node<T> prev = null;
        int counter = 0;

        while (curr != null) {
            if (counter == index) {
                if (prev != null) {
                    prev.setNext(curr.getNext());
                } else {
                    if (curr.getNext() != null) {
                        this.head = curr.getNext();
                    }
                }
                size--;
                return curr.getValue();
            }
            prev = curr;
            curr = curr.getNext();
            counter++;
        }
        throw new IndexOutOfBoundsException("LinkedList delete at " + index);
    }

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

    public void update(int index, T value) {
        Node<T> curr = this.head;
        int counter = 0;

        while (curr != null) {
            if (index == counter) {
                curr.setValue(value);
            }
            curr = curr.getNext();
            counter++;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node<T> curr = this.head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.getValue().toString());
            sb.append(" ");
            curr = curr.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final LinkedList<Integer> list = new LinkedList<>();
        list.addBefore(0, 2);
        list.addBefore(0, 4);
        list.addBefore(0, 5);      // 5, 4, 2
        list.addBefore(0, 10);     // 10, 5, 4, 2
        list.addBefore(1, 200);    // 10, 200, 5, 4, 2
        list.remove(0);                 // 200, 5, 4, 2
        list.update(2, 10);       // 200, 5, 10, 2
        System.out.println(list);
        System.out.println(list.size());

        final Integer[] array = {2, 3, 4, 5};
        final LinkedList<Integer> list2 = new LinkedList<>(array);
        System.out.println(list2);
        System.out.println(list2.size());
    }
}