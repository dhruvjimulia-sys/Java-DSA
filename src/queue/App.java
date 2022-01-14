package queue;

public class App {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.toString());
    }
}
