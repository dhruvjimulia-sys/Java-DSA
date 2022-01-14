package queue;

// Circular Queue: Make Simple Queue and Change to Circular
public class Queue {
    public Object[] queueArr;
    private int front;
    private int rear;
    public int maxSize;

    public Queue(int size) {
        this.queueArr = new Object[size];
        this.front = -1;
        this.rear = -1;
        this.maxSize = size;
    }

    public void enqueue(Object obj) {
        if (this.isFull()) {
            throw new Error("Cannot enqueue: Queue is full");
        } else if (this.isEmpty()) {
            this.front = 0;
            this.rear = 0;
        } else {
            this.rear++;
        }
        this.queueArr[this.rear] = obj;
    }

    public Object dequeue() {
        Object removed = this.queueArr[this.front];
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

    public boolean isEmpty() {
        return (this.front == -1 && this.rear == -1);
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.queueArr) {
            if (obj == null) {
                sb.append("null ");
            } else {
                sb.append(obj.toString());
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
