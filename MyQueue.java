import java.util.NoSuchElementException;

public class MyQueue implements IQueue {
	
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
	
	Node queue, last;	//declaring Nodes
	
	public void enqueue(Object item) {
		Node n = new Node(item);
		if(this.queue == null) {
			this.queue = n;
			this.last = n;
			return;
		}
		this.last.next = n;
		this.last = n;
	}	//end of enqueue()
	
	public Object dequeue() {
		try {
			if(queue == null)
				throw new NoSuchElementException();
			Object item = this.queue.item;
			this.queue = this.queue.next;
			return item;
		} catch (NoSuchElementException e) {
			return "";
		}
	}	//end of dequeue()
	
	public Object peek() {
		try {
			if(queue == null)
				throw new NoSuchElementException();
			Object item = this.queue.item;
			return item;
		} catch (NoSuchElementException e) {
			return "";
		}
	}	//end of peek()
	
	public int indexOf(Object item) {
		Node m = this.queue;
		int index = -1;
		while(m != null) {
			index++;
			if(item == m.item)
				return index;
			m = m.next;
		}
		return -1;
	}	//end of indexOf()
	
	public int getSize() {
		Node o = this.queue;
		int si = 0;
		while(o != null) {
			si++;
			o = o.next;
		}
		return si;
	}	//end of getSize()
	
	public boolean isEmpty() {
		return this.queue == null;
	}	//end of isEmpty()
}	//end of class MyQueue
