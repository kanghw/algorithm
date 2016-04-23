package algo;

public class Node {
	Node next = null;
	
	String data;
	public Node(String d){
		this.data = d;
	}
	
	public void appendToTail(String d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
}
