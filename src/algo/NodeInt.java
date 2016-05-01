package algo;

public class NodeInt {
	NodeInt next = null;
	
	int data;
	public NodeInt(int d){
		this.data = d;
	}
	
	public void appendToTail(int d){
		NodeInt end = new NodeInt(d);
		NodeInt n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
}
