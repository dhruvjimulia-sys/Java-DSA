package list.doublylinkedlist;

// Linked List
// Quick Insertion and Deletion at beginning of list / close to beginnning of list
// Dynamic Size

public class DoublyLinkedList {
    public ListNode head;
    public ListNode tail;
    public int size;

    public DoublyLinkedList() {
        this.size = 0;
    }
    public DoublyLinkedList(Object[] objectsArr) {
        this.size = objectsArr.length;
        if (objectsArr.length == 1) {
            ListNode headtailnode = new ListNode(objectsArr[0]);
            this.head = headtailnode;
            this.tail = headtailnode;
        } else if (objectsArr.length > 1) {

            ListNode currNode;
            // Traversing array backwards to set .next property
            currNode = null;
            ListNode nextNode = new ListNode(objectsArr[objectsArr.length - 1]);
            for (int i = objectsArr.length - 2; i >= 0; i--) {
                currNode = new ListNode(objectsArr[i], nextNode);
                nextNode = currNode;
            }

            this.head = currNode;

            // Traversing linked list forward to set .prev property
            currNode = this.head;
            ListNode prevNode = null;
            while (currNode != null) {
                currNode.prev = prevNode;
                prevNode = currNode;
                currNode = currNode.next;
            }
            this.tail = prevNode;
        }
    }

    public void appendNode(Object obj) {
        if (this.head == null) {
            ListNode headtailnode = new ListNode(obj);
            this.head = headtailnode;
            this.tail = headtailnode;
            return;
        }

        ListNode newNode = new ListNode(this.tail, obj);
        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    public void prependNode(Object obj) {
        if (this.head == null) {
            ListNode headtailnode = new ListNode(obj);
            this.head = headtailnode;
            this.tail = headtailnode;
            return;
        }

        ListNode newFirstNode = new ListNode(obj, this.head);
        this.head.prev = newFirstNode;
        this.head = newFirstNode;
        this.size++;
    }

    public void insertNewNodeAfterIndex(int index, Object obj) {
        boolean reverseTraversal = index > Math.floor(this.size/2);
        ListNode curr;
        int counter;
        if (reverseTraversal) {
            curr = this.tail;
            counter = this.size;
        } else {
            curr = this.head;
            counter = 0;
        }

        while (curr != null) {
            if (counter == index) {
                ListNode newNode = new ListNode(curr, obj, curr.next);
                if (curr.next != null) curr.next.prev = newNode;
                curr.next = newNode;
                this.size++;
                return;
            }
            if (reverseTraversal) {
                curr = curr.prev;
                counter--;
            } else {
                curr = curr.next;
                counter++;
            }
        }
        throw new IndexOutOfBoundsException("LinkedList Insert: No Node Exists With Given Index");
    }

    // One more loop to find previous node
    public void deleteNodeAtIndex(int index) {
        // Checking if reverse traversal is more efficient
        boolean reverseTraversal = index > Math.floor(this.size/2);
        ListNode curr;
        int counter;
        if (reverseTraversal) {
            curr = this.tail;
            counter = this.size;
        } else {
            curr = this.head;
            counter = 0;
        }

        while (curr != null) {
            if (counter == index) {
                curr.val = null;
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                curr.next = null;
                this.size--;
                return;
            }

            // Deciding reverse traversal vs front traversal based on earlier boolean
            if (reverseTraversal) {
                curr = curr.prev;
                counter--;
            } else {
                curr = curr.next;
                counter++;
            }
        }
        throw new IndexOutOfBoundsException("LinkedList Delete: No Node Exists With Given Index");
    }

    public void updateNodeAtIndex(int index, Object obj) {
        boolean reverseTraversal = index > Math.floor(this.size/2);
        ListNode curr;
        int counter;
        if (reverseTraversal) {
            curr = this.tail;
            counter = this.size;
        } else {
            curr = this.head;
            counter = 0;
        }

        while (curr != null) {
            if (index == counter) {
                curr.val = obj;
            }
            if (reverseTraversal) {
                curr = curr.prev;
                counter--;
            } else {
                curr = curr.next;
                counter++;
            }
        }
    }

    public void displayList() {
        ListNode curr = this.head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.prev != null ? curr.prev.val.toString() : curr.prev);
            sb.append(" ");
            sb.append(curr.val.toString());
            sb.append(" ");
            sb.append(curr.next != null ? curr.next.val.toString() : curr.next);
            sb.append("\n");
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }
}