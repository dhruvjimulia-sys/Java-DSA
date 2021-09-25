package singlylinkedlist;

public class ListNode{
    private Object val;
    private ListNode next;

    public ListNode(){}

    public ListNode(Object val){
        this.val = val;
    }

    public ListNode(Object val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public Object getCurrentValue() {
        return this.val;
    }

    public ListNode getNextNode() {
        return this.next;
    }

    public void setNextNode(ListNode next) {
        this.next = next;
    }

    public void setCurrentValue(Object obj) {
        this.val = obj;
    }
}