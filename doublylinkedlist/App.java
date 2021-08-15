package doublylinkedlist;

// Adavntages of Doubly Linked List Over Singly Linked List
// O(n) backward traversal
// More efficient deletions
// Add/Remove closer to the tail node relatively fast

public class App {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.appendNode(3);
        list.appendNode(4);
        list.appendNode(5);
        // 3, 4, 5
        list.prependNode(2);
        // 2, 3, 4, 5
        list.insertNewNodeAfterIndex(1, 100);
        // 2, 3, 100, 4, 5
        list.deleteNodeAtIndex(1);
        // 2, 100, 4, 5
        list.updateNodeAtIndex(3, 10);
        // 2, 100, 4, 10
        list.displayList();

        Integer[] integerList = {20, 10, 23, 40};
        DoublyLinkedList list2 = new DoublyLinkedList(integerList);
        list2.displayList();
    }
}
