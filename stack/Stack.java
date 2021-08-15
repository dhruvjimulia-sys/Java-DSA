package stack;

public class Stack {
    public Object[] stackArr;
    public int maxSize;
    public int currSize;

    public Stack(int size) {
        this.stackArr = new Object[size];
        this.maxSize = size;
        currSize = 0;
        System.out.println(this.stackArr);
    }

    public void push(Object object) {
        if (currSize + 1 > maxSize) {
            throw new Error(String.format("Stack Overflow: Exceeded stack of size %s", maxSize));
        } else {
            this.stackArr[currSize] = object;
            currSize++;
        }
    }

    public Object pop(Object object) {
        if (currSize == 0) {
            throw new Error("Stack Underflow: Cannot pop empty stack");
        } else {
            Object removedObject = this.stackArr[currSize - 1];
            this.stackArr[currSize - 1] = null;
            currSize--;
            return removedObject;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.stackArr) {
            if (obj != null) {
                sb.append(obj.toString());
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
