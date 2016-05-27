package algo;

import org.junit.Test;

public class Algo_3 {
    @Test
	public void test(){
//		this.algo_3_1();
//        this.algo_3_2();
//        this.algo_3_3();
//		this.algo_3_4();
		this.algo_3_5();
	}

	private void algo_3_5() {
		StackQue stackQue = new StackQue();
		stackQue.push(1);
		stackQue.push(2);
		stackQue.push(3);
		stackQue.push(4);
		stackQue.push(5);
		System.out.println(stackQue.pop());
		stackQue.push(6);
		System.out.println(stackQue.pop());
		stackQue.push(7);
		System.out.println(stackQue.pop());
	}

	private void algo_3_4() {
		for( int i = 10 ; i < 11 ; i++ ){
//			System.out.println( "하노이 원반 개수 = " + i + ", 이동 횟수 = " + hanoi(i, 0) );
			System.out.println( "하노이 원반 개수 = " + i + ", 이동 횟수 = " + hanoi3(i) + " <<<<<< a size = " + a.size() + ", b size = " + b.size() + ", c size = " + c.size() );
		}
	}

	int hanoi(int count, int allCount){
		if( count < 1 ){
			return 0;
		}
		if( count == 1 ){
			return 1;
		}
		if( count == 2 ){
			return 3;
		}
		allCount += hanoi( count - 1, allCount ) * 2 + 1;
		return allCount;
	}

	int hanoiCount = 0;
	StackInt a = new StackInt("a");
	StackInt b = new StackInt("b");
	StackInt c = new StackInt("c");

	void stackIntInit(){
		a = new StackInt("a");
		b = new StackInt("b");
		c = new StackInt("c");
		hanoiCount = 0;
	}

	int hanoi3(int size){
		stackIntInit();
		// 최초 전체 카운트를 기본 스택에 채운다.
		for( int i = size ; i > 0 ; i-- ){
			a.push(i);
		}
		hanoi3_1(size, a, b, c);
		return hanoiCount;
	}

	void hanoi3_1(int n, StackInt from, StackInt by, StackInt to){
		if( n == 1 ){
			move(from, to);
		} else {
			hanoi3_1(n - 1, from, to, by);
			move(from, to);
			hanoi3_1(n - 1, by, from, to);
		}
	}
	void move(StackInt from, StackInt to){
		to.push(from.pop());
//		System.out.println(from.name + " to " + to.name + " -> " + to.peek().data);
		hanoiCount++;
	}

	public void algo_3_3(){
		StackLimitList stack = new StackLimitList(5);
		for( int i = 1 ; i <= 100 ; i++ ){
			stack.push(i);
		}
		for( int i = 1 ; i <= 50 ; i++ ) {
			System.out.println(stack.pop());
		}
		for( int i = 101 ; i <= 200 ; i++ ){
			stack.push(i);
		}
		System.out.println(stack.popAt(3));

		for( int i = 1 ; i <= 152 ; i++ ) {
			System.out.println(stack.pop());
		}
	}

    public void algo_3_2(){
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(5);
        minStack.push(9);
        minStack.push(5);
        minStack.push(6);
        minStack.push(8);
        minStack.push(2);
        minStack.push(1);
        minStack.push(3);

        System.out.println("min > " + minStack.min().data);
        System.out.println("pop = " + minStack.pop().data);
        System.out.println("pop = " + minStack.pop().data);
        System.out.println("min > " + minStack.min().data);
        System.out.println("min > " + minStack.min().data);
        System.out.println("pop = " + minStack.pop().data);
        System.out.println("min > " + minStack.min().data);
        System.out.println("min > " + minStack.min().data);
    }
	
	private void algo_3_1() {
//		String[] strArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//		String[] strArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
		String[] strArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

		Stack[] result = this.algo_3_1_2(strArr, 3);
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
		
		//int oneCount = (int) Math.round(len / 3);
		int oneCount = (int) len / 3;
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
