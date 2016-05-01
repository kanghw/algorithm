package algo;

public class Stack {
	Node top;
	
	String pop(){
		if( top != null ){
			String item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(String str){
		Node t = new Node(str);
		t.next = top;
		top = t;
	}
	
	Node peek(){
		return top;
	}
}
