package ie.raglansoftware.linkedlist;

public class DoublyLinkedList {
	private ListNode head;
		
	public void add(Object object) {
		ListNode newNode = new ListNode(object);
		if (head==null) {
			head = newNode;
		}
		head.setNext(newNode);
	}
	
	public void remove(Object object) {
		ListNode toRemove = find(object);
		if (toRemove==null) {
			return;
		}
		ListNode previous = toRemove.getPrevious();
		ListNode next = toRemove.getNext();
		
		previous.setNext(next);
		next.setPrevious(previous);
	}
	
	public ListNode find(Object value) {
		if(head!=null && head.equals(value))
			return head;
		
		ListNode current = null;
		while (!current.equals(value)) {
			current = head.getNext();
		}
		return current;
	}
}
