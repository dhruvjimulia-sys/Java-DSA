package list.circularlinkedlist;

public class App {
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.prependNode(2);
        list.appendNode(3);
        list.prependNode(4);
        // 4, 2, 3
        list.insertNewNodeAfterIndex(2, 7);
        // 4, 2, 3, 7
        list.deleteNodeAtIndex(0);
        // 2, 3, 7
        list.updateNodeAtIndex(1, 10);
        // 2, 10, 7
        list.displayList();


        Integer[] intArray = {2, 3, 4};
        CircularSinglyLinkedList list2 = new CircularSinglyLinkedList(intArray);
        list2.displayList();
    }
}
