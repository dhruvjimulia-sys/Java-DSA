package circularqueue;

public class App {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.dequeue();
        System.out.println(queue.toString());
    }
}
