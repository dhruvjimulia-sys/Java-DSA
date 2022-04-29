package list.circularlinkedlist;

// Linked List
// Quick Insertion and Deletion at beginning of list / close to beginnning of list
// Dynamic Size

public class CircularSinglyLinkedList {
    public ListNode head;
    public int size;

    public CircularSinglyLinkedList() {
        this.size = 0;
    }
    public CircularSinglyLinkedList(Object[] objectsArr) {
        this.size = objectsArr.length - 1;
        if (objectsArr.length == 1) {
            this.head = new ListNode(objectsArr[0]);
            this.head.setNextNode(this.head);
        } else if (objectsArr.length > 1) {
            ListNode currNode = null;
            ListNode endNode = new ListNode(objectsArr[objectsArr.length - 1]);
            ListNode nextNode = endNode;
            for (int i = objectsArr.length - 2; i >= 0; i--) {
                currNode = new ListNode(objectsArr[i], nextNode);
                nextNode = currNode;
            }
            this.head = currNode;
            endNode.setNextNode(this.head);
        }
    }

    public void appendNode(Object obj) {
        if (this.head == null) {
            this.head = new ListNode(obj);
            this.head.setNextNode(this.head);
            return;
        }

        ListNode current = this.head;
        for (int i = 0; i < this.size; i++) {
            current = current.getNextNode();
        }

        ListNode newNode = new ListNode(obj, this.head);
        current.setNextNode(newNode);
        this.size++;
    }

    public void prependNode(Object obj) {
        if (this.head == null) {
            this.head = new ListNode(obj);
            this.head.setNextNode(this.head);
            return;
        }

        ListNode current = this.head;
        for (int i = 0; i < this.size; i++) {
            current = current.getNextNode();
        }
        ListNode tailNode = current;
        
        ListNode newFirstNode = new ListNode(obj, this.head);
        this.head = newFirstNode;
        tailNode.setNextNode(this.head);
        this.size++;
    }

    public void insertNewNodeAfterIndex(int index, Object obj) {
        ListNode curr = this.head;

        for (int i = 0; i <= this.size; i++) {
            if (i == index) {
                ListNode newNode = new ListNode(obj, curr.getNextNode());
                curr.setNextNode(newNode);
                this.size++;
                return;
            }
            curr = curr.getNextNode();
        }
        throw new IndexOutOfBoundsException("LinkedList Insert: No Node Exists With Given Index");
    }

    // One more loop to find previous node
    public void deleteNodeAtIndex(int index) {
        ListNode curr = this.head;
        for (int i = 0; i < this.size; i++) {
            curr = curr.getNextNode();
        }

        ListNode prev = curr;
        curr = this.head;

        for (int i = 0; i <= this.size; i++) {
            if (i == index) {
                prev.setNextNode(curr.getNextNode());
                if (index == 0) this.head = curr.getNextNode();
                curr.setNextNode(null);
                curr.setCurrentValue(null);
                this.size--;
                return;
            }
            prev = curr;
            curr = curr.getNextNode();
        }
        throw new IndexOutOfBoundsException("LinkedList Delete: No Node Exists With Given Index");
    }

    public void updateNodeAtIndex(int index, Object obj) {
        ListNode curr = this.head;

        for (int i = 0; i < this.size; i++) {
            if (index == i) {
                curr.setCurrentValue(obj);
            }
            curr = curr.getNextNode();
        }
    }

    public void displayList() {
        ListNode curr = this.head;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= this.size; i++) {
            sb.append(curr.getCurrentValue());
            sb.append(" ");
            sb.append(curr.getNextNode().getCurrentValue());
            sb.append("\n");
            curr = curr.getNextNode();
        }
        System.out.println(sb.toString());
    }
}