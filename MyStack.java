import java.util.NoSuchElementException;

public class MyStack implements IStack {
	
	class Node {	//setting up our Nodes
		Object item;
		Node next;
		Node(Object item) {
			this.item = item;
			this.next = null;
		}
		Node() {
			this.item = -1;
			this.next = null;
		}
	}	//end of class Node
	
	Node stack;	//declaring node 'stack'
	
	public void push(Object item) {
		Node n = new Node(item);
		if (this.stack == null) {
			this.stack = n;
			return;
		}
		n.next = this.stack;
		this.stack = n;
	}	//end of push()
	
	public Object pop() {
		try {
			if (stack == null) {
				throw new NoSuchElementException();
			}
			Object item = this.stack.item;
			this.stack = this.stack.next;
			return item;
		}
		catch (NoSuchElementException e) {
			return "";
		}
	}	//end of pop()
	
	public Object peek() {
		try {
			if (stack == null) {
				throw new NoSuchElementException();
			}
			Object item = this.stack.item;
			return item;
		}
		catch (NoSuchElementException e) {
			return "";
		}
	}	//end of peek()
	
	public int indexOf(Object item) {
		Node m = this.stack;
		int index = -1;
		while (m != null) {
			index++;
			if (item == m.item)
				return index;
			m = m.next;
		}
		return -1;
	}	//end of indexOf()
	
	public int getSize() {
		Node o = this.stack;
		int si = 0;
		while (o != null) {
			si++;
			o = o.next;
		}
		return si;
	}	//end of getSize()
	
	public boolean isEmpty() {
		return this.stack == null;
	}	//end of isEmpty()
	
}	//end of class MyStack
