package ie.raglansoftware.linkedlist;

public class ListNode {
	
	private ListNode next;
	private ListNode previous;
	
	private Object value;
	
	public ListNode(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode getNext() {
		return this.next;
	}

	public void setPrevious(ListNode previous) {
		this.previous = previous;
	}
	
	public ListNode getPrevious() {
		return this.previous;
	}
}
