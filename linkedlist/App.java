package linkedlist;

public class App {
    public static void main(String args[]) {
        // Creating Linked List from Java Array

        int[] numbers = {10, 20, 34, 56};
        ListNode[] listnodes = new ListNode[numbers.length];
        ListNode nextNode = new ListNode(numbers[numbers.length - 1]);
        listnodes[listnodes.length - 1] = nextNode;

        for (int i = numbers.length - 2; i >= 0; i--) {
            ListNode currNode = new ListNode(numbers[i], nextNode);
            listnodes[i] = currNode;
            nextNode = currNode;
        }
        
        System.out.println(listnodes[0].getCurrentValue() + " " + listnodes[0].getNextNode().getCurrentValue());
    }

    // public ListNode[] splitListToParts(ListNode head, int k) {
    //     ListNode curr = head;
    //     int len = 0;
    //     while (curr != null) {
    //         len++;
    //         curr = curr.getNextNode();
    //     }
    //     System.out.println(len);
    //     return null;
    // }
}