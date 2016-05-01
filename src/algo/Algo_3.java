package algo;

import org.junit.Test;

public class Algo_3 {
	@Test
	public void test(){
		this.algo_3_1();
	}
	
	private void algo_3_1() {
		String[] strArr = {"kang", "hyun", "wook", "k", "h", "w", "1", "2", "3", "4", "5"};
		
		Stack[] result = this.algo_3_1_2(strArr, 4);
		for( int i = 0; i < result.length; i++ ){
			Stack temp = result[i];
			while( temp.top != null ){
				System.out.println("result[" + i + "] = " + temp.pop());
			}
		}
	}

	// 배열을 받아서 n개의 스택에 저장하는 방법.
	public Stack[] algo_3_1_2(String[] strArr, int stackSize){
		if( strArr == null ){
			return null;
		}
		int len = strArr.length;
		Stack[] stackArr = new Stack[stackSize];
		
		int oneCount = (int) Math.round(len / 3);
		System.out.println("Array Length = " + len + ", oneCount = " + oneCount);
		int stackCount = 0;
		for (int i = 0; i < len; i++) {
			if( stackArr[stackCount] == null ){
				stackArr[stackCount] = new Stack();
			}
			stackArr[stackCount].push(strArr[i]);
			
			if( (i + 1) % oneCount == 0 
					&& stackCount < stackSize - 1 ){
				stackCount++;
			}
		}
		return stackArr;
	}
	
	Node createNode(String[] strArr){
		int len = strArr.length;
		if (len == 0) {
			return null;
		}
		Node node = new Node(strArr[0]);
		for (int i = 1; i < len; i++) {
			node.appendToTail(strArr[i]);
		}
		return node;
	}
}
