package stack;

public class ArrayStack<T> implements Stack<T> {
    public static final int DEFAULT_STACK_SIZE = 5;
    private T[] stackArr;
    private int maxSize;
    private int size;

    public ArrayStack() {
        this(DEFAULT_STACK_SIZE);
    }

    public ArrayStack(int maxSize) {
        this.stackArr = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
        this.size = 0;
    }

    @Override
    public void push(T value) {
        if (size + 1 > maxSize) {
            T[] newStackArr = (T[]) new Object[maxSize * 2];
            maxSize *= 2;
            System.arraycopy(stackArr, 0, newStackArr, 0, size);
            stackArr = newStackArr;
        }
        this.stackArr[size] = value;
        size++;
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack underflow: pop empty stack");
        } else {
            T removedT = this.stackArr[size - 1];
            this.stackArr[size - 1] = null;
            size--;
            return removedT;
        }
    }

    @Override
    public T peek() {
        return stackArr[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T obj : this.stackArr) {
            if (obj != null) {
                sb.append(obj.toString());
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        // stack.peek();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
