package singlylinkedlist;

// Linked List
// Quick Insertion and Deletion at beginning of list / close to beginnning of list
// Dynamic Size

public class SinglyLinkedList {
    public ListNode head;

    public SinglyLinkedList() {}
    public SinglyLinkedList(Object[] objectsArr) {
        if (objectsArr.length == 1) {
            this.head = new ListNode(objectsArr[0]);
        } else if (objectsArr.length > 1) {
            ListNode currNode = null;
            ListNode nextNode = new ListNode(objectsArr[objectsArr.length - 1]);
            for (int i = objectsArr.length - 2; i >= 0; i--) {
                currNode = new ListNode(objectsArr[i], nextNode);
                nextNode = currNode;
            }
            this.head = currNode;
        }
    }

    public void appendNode(Object obj) {
        if (this.head == null) {
            this.head = new ListNode(obj);
            return;
        }

        ListNode current = this.head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }

        ListNode newNode = new ListNode(obj);
        current.setNextNode(newNode);
    }

    public void prependNode(Object obj) {
        ListNode newFirstNode = new ListNode(obj, this.head);
        this.head = newFirstNode;
    }

    public void insertNewNodeAfterIndex(int index, Object obj) {
        ListNode curr = this.head;
        int counter = 0;

        while (curr != null) {
            if (counter == index) {
                ListNode newNode = new ListNode(obj, curr.getNextNode());
                curr.setNextNode(newNode);
                return;
            }
            curr = curr.getNextNode();
            counter++;
        }
        throw new IndexOutOfBoundsException("LinkedList Insert: No Node Exists With Given Index");
    }

    // One more loop to find previous node
    public void deleteNodeAtIndex(int index) {
        ListNode curr = this.head;
        ListNode prev = null;
        int counter = 0;

        while (curr != null) {
            if (counter == index) {
                if (prev != null) {
                    prev.setNextNode(curr.getNextNode());
                    curr.setNextNode(null);
                    curr.setCurrentValue(null);
                } else {
                    curr.setCurrentValue(null);
                    if (curr.getNextNode() != null) {
                        this.head = curr.getNextNode();
                    }
                }
                return;
            }
            prev = curr;
            curr = curr.getNextNode();
            counter++;
        }
        throw new IndexOutOfBoundsException("LinkedList Delete: No Node Exists With Given Index");
    }

    public void updateNodeAtIndex(int index, Object obj) {
        ListNode curr = this.head;
        int counter = 0;

        while (curr != null) {
            if (index == counter) {
                curr.setCurrentValue(obj);
            }
            curr = curr.getNextNode();
            counter++;
        }
    }

    public void displayList() {
        ListNode curr = this.head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.getCurrentValue().toString());
            sb.append(" ");
            curr = curr.getNextNode();
        }
        System.out.println(sb.toString());
    }
}