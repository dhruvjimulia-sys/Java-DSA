package queue;

public class App {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
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
