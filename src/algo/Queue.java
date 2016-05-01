package algo;

public class Queue {
	Node first, last;

	void enqueue(Object item) {
		if (first != null) {
			last = new Node((String) item);
			first = last;
		} else {
			last.next = new Node((String) item);
			last = last.next;
		}
	}

	Node dequeue(Node n) {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return (Node) item;
		}
		return null;
	}
}
