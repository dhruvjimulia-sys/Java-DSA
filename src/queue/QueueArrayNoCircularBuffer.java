package queue;

public class QueueArrayNoCircularBuffer<T> implements Queue<T> {
    public T[] queueArr;
    private int front;
    private int rear;
    public int maxSize;

    public QueueArrayNoCircularBuffer(int size) {
        this.queueArr = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
        this.maxSize = size;
    }

    @Override
    public void enqueue(T value) {
        if (this.isFull()) {
            throw new Error("Cannot enqueue: Queue is full");
        } else if (this.isEmpty()) {
            this.front = 0;
            this.rear = 0;
        } else {
            this.rear++;
        }
        this.queueArr[this.rear] = value;
    }

    @Override
    public T dequeue() {
        T removed = this.queueArr[this.front];
        this.queueArr[this.front] = null;
        if (this.isEmpty()) {
            throw new Error("Cannot dequeue: Queue is empty");
        } else if (this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
        } else {
            this.front++;
        }
        return removed;
    }

    @Override
    public boolean isEmpty() {
        return (this.front == -1 && this.rear == -1);
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.queueArr) {
            if (value == null) {
                sb.append("null ");
            } else {
                sb.append(value.toString());
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueArrayNoCircularBuffer<>(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        // Following code results in error since no circular buffer
        // queue.enqueue(6);
        System.out.println(queue.toString());
    }
}
