package binarysearchtree;

public class QueueArrayCircularBuffer<T> implements Queue<T> {
    public T[] queueArr;
    private int front;
    private int rear;
    public int maxSize;

    public QueueArrayCircularBuffer(int size) {
        this.queueArr = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
        this.maxSize = size;
    }

    public void enqueue(T value) {
        if (this.isFull()) {
            throw new Error("Cannot enqueue: Queue is full");
        } else if (this.isEmpty()) {
            this.front = 0;
            this.rear = 0;
        } else {
            this.rear = (this.rear + 1) % this.maxSize;
        }
        this.queueArr[this.rear] = value;
    }

    public T dequeue() {
        T removed = this.queueArr[this.front];
        this.queueArr[this.front] = null;
        if (this.isEmpty()) {
            throw new Error("Cannot dequeue: Queue is empty");
        } else if (this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
        } else {
            this.front = (this.front + 1) % this.maxSize;
        }
        return removed;
    }

    public boolean isEmpty() {
        return (this.front == -1 && this.rear == -1);
    }

    public boolean isFull() {
        return this.front == (this.rear + 1) % this.maxSize;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (T value : this.queueArr) {
            if (value == null) {
                sb.append("null ");
            } else {
                sb.append(value);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueArrayCircularBuffer<Integer> queue =
            new QueueArrayCircularBuffer<>(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        // Following code does not result in error because of circular buffer
        queue.enqueue(6);
        System.out.println(queue);
    }
}
