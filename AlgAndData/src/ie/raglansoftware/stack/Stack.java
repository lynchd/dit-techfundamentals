package ie.raglansoftware.stack;

public class Stack 
{
	private final Object[] stack;
	private int head;
	
	public Stack(int size) {
		stack = new Object[size];
		head = 0;
	}
	
	public void push(Object element) 
		throws IllegalArgumentException
	{
		if (head==stack.length) {
			throw new IllegalArgumentException("Stack is full");
		}
		stack[head]=element;
		head++;
	}
	
	public Object pop() 
		throws Exception
	{
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		head--;
		return stack[head];
	};
	
	public Object peek() 
		throws Exception
	{
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		return stack[head];
	}
	
	public boolean isEmpty() {
		return (stack[0]==null);
	}
}