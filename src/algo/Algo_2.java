package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class Algo_2 {
	@Test
	public void test(){
//		this.algo_2_1();
//		this.algo_2_2();
//		this.algo_2_3();
		this.algo_2_4();
	}
	
	public void algo_2_1() {
		Assert.assertTrue("abcdefg".equals(this.algo_2_1("abcdcedfg")));
		Assert.assertTrue("가나다라마바사".equals(this.algo_2_1("가나다가라마마바나사")));
	}

	// node 에서 중복 문자 제거.
	public String algo_2_1(String source) {
		Node node = this.createNode(source);
		String ori = this.getNodeData(node);
		System.out.println("원본문자 = " + ori);
		List<String> list = new ArrayList<>();
		Node clone = node;
		while (node != null) {
			if (list.contains(node.data)) {
				node.data = node.next.data;
				node.next = node.next.next;
			} else {
				list.add(node.data);
			}
			node = node.next;
		}
		String result = this.getNodeData(clone);
		System.out.println("중복제거 = " + result);
		return result;
	}
	
	public void algo_2_2() {
		Assert.assertTrue("k".equals(this.algo_2_2("abcdefghiadkjfdl", 5).data));
		Assert.assertTrue("f".equals(this.algo_2_2("abcdefghiadkjl", 9).data));
		Assert.assertTrue("사".equals(this.algo_2_2("가나다라마바사아자차카", 5).data));
		Assert.assertTrue("가".equals(this.algo_2_2("가나다라마바사아자차카", 11).data));
		Assert.assertTrue(this.algo_2_2("가나다라마바사아자차카", 25) == null);

		// BenchMark bench = new BenchMark();
		//
		// Node k = null;
		// for (int i = 0; i < 100000; i++) {
		// k = this.algo_2_2("abcdefghiadkjfdl", 5);
		// }
		// System.out.println(k.data);
		//
		// bench.end();
		// bench.printResult();
	}

	// 뒤에서 k 번째 node 를 반환하라.
	public Node algo_2_2(String source, int k) {
		Node node = this.createNode(source);
		Node store = node;
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		if (len < k) {
			return null;
		}
		int forK = len - k;
		for (int i = 0; i < forK; i++) {
			store = store.next;
		}
		return store;
	}

	public Node algo_2_2_2(String source, int k) {
		Node node = this.createNode(source);
		int len = 0;
		List<Node> list = new ArrayList<>();
		while (node != null) {
			len++;
			list.add(node);
			node = node.next;
		}
		return list.get(len - k);
	}
	
	public void algo_2_3(){
		for( int i = 0; i < 100; i++ ){
			this.algo_2_3_random_test();
		}
		this.algo_2_3_test("abcdefghijk", 5);
		this.algo_2_3_test("abcdefghijk", 0);
		this.algo_2_3_test("abcdefghijk", 11);
		this.algo_2_3_test("abcdefghijk", 12);
	}
	
	public void algo_2_3_random_test(){
		Random rand = new Random();
		String source = Integer.toString(Math.abs(rand.nextInt()));
		int len = source.length();
		int ma = Math.abs(rand.nextInt() % len);
//		System.out.println( "원본 문자열 = " + source );
//		System.out.println( "원본 문자열 길이 = " + len );
//		System.out.println( "지울 node k = " + ma );		
		Node test = this.createNode(source);
		for( int i = 0; i < ma; i++ ){
			test = test.next;
		}
		
		String ori = this.getNodeData(test);
		test = this.algo_2_3(test);
		String convert = this.getNodeData(test);
		System.out.println("원본 = " + ori);
		System.out.println("변환 -> " + convert);
		Assert.assertTrue( ori.substring(1).equals(convert) );
	}
	
	public void algo_2_3_test(String source, int k){
		Node test = this.createNode(source);
		for (int i = 0; i < k; i++) {
			if( test == null ){
				System.out.println("반복 횟수가 소스 문자열보다 큼.");
				break;
			}
			test = test.next;
		}
		String ori = this.getNodeData(test);
		test = this.algo_2_3(test);
		String convert = this.getNodeData(test);
		System.out.println("원본 = " + ori);
		System.out.println("변환 -> " + convert);
		if( ori.length() >= 1 ){
			Assert.assertTrue( ori.substring(1).equals(convert) );
		} else {
			Assert.assertTrue( ori.equals(convert) );
		}
		
	}
	
	// Node d 가 주어졌을 때 d를 삭제하는 함수.
	public Node algo_2_3(Node d){
		if( d == null ){
			return null;
		}
		if( d.next == null ){
			d = null;
		} else {
			d.data = d.next.data;
			d.next = d.next.next;
		}
		return d;
	}
	
	public void algo_2_4(){
		List<Node> result;
		
		result = this.algo_2_4(this.createNode("123456"), "1");
		printNodeList(result);
		
		result = this.algo_2_4(this.createNode("12345673999"), "3");
		printNodeList(result);
		
		result = this.algo_2_4(this.createNode("123456"), "6");
		printNodeList(result);
		
		result = this.algo_2_4(this.createNode("123456"), "a");
		printNodeList(result);
	}

	private void printNodeList(List<Node> result) {
		for (int i = 0; i < result.size(); i++) {
			System.out.println("result[" + i + "] = " + this.getNodeData(result.get(i)));
		}
		System.out.println();
	}
	
	// x 값을 갖는 노드를 기준으로 기존 node 를 나누는 함수.
	public List<Node> algo_2_4(Node origin, String n){
		List<Node> result = new ArrayList<>();
		System.out.println("원본 = " + this.getNodeData(origin));
		System.out.println("분리 기준 = " + n);
		int cnt = 0;
		// 주소값 저장을 위한 임시 Node
		Node temp = null;
		while( origin != null ){
			// node, 결과 배열 초기화.
			if( result.size() == cnt ){
				temp = new Node(origin.data);
				result.add(temp);
			}
			// 넘어온 노드와 같은 데이터를 가진 경우. cnt++
			// 다를 경우에는 next 셋팅.
			if( origin.data.equals(n) ){
				cnt++;
			} else {
				if( origin.next != null ){
					temp.next = new Node(origin.next.data);
				}
				temp = temp.next;
			}
			// origin 진행.
			origin = origin.next;
		}
		return result;
	}

	Node createNode(String source) {
		int len = source.length();
		if (len == 0) {
			return null;
		}
		Node node = new Node(source.substring(0, 1));
		for (int i = 1; i < len; i++) {
			node.appendToTail(source.substring(i, i + 1));
		}
		return node;
	}

	String getNodeData(Node node) {
		StringBuffer result = new StringBuffer();
		while (node != null) {
			result.append(node.data);
			node = node.next;
		}
		return result.toString();
	}
	
	Node cloneNode(Node node){
		Node result = new Node(node.data);
		while( node != null ){
			node = node.next;
			result.next = new Node(node.data);
		}
		return result;
	}
}
