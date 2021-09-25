package singlylinkedlist;

public class App {
    public static void main(String args[]) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.appendNode(2);
        list.appendNode(4);
        list.appendNode(5);
        // 2, 4, 5
        list.prependNode(10);
        // 10, 2, 4, 5
        list.insertNewNodeAfterIndex(0, 200);
        // 10, 200, 2, 4, 5
        list.deleteNodeAtIndex(0);
        // 200, 2, 4, 5
        list.updateNodeAtIndex(2, 10);
        // 200, 2, 10, 5
        list.displayList();

        Integer[] array = {2, 3, 4, 5};
        SinglyLinkedList list2 = new SinglyLinkedList(array);
        list2.displayList();
    }
}