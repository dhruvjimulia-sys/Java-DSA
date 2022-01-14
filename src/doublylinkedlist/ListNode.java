package doublylinkedlist;

public class ListNode{
    public Object val;
    public ListNode next;
    public ListNode prev;

    public ListNode(){}

    public ListNode(Object val) {
        this.val = val;
    }

    public ListNode(ListNode prev, Object val){
        this.val = val;
        this.prev = prev;
    }

    public ListNode(Object val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode prev, Object val, ListNode next){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}