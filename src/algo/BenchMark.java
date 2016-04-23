package algo;

public class BenchMark {
	private long start, end;

	public BenchMark() {
		this.start = System.currentTimeMillis();
	}
	
	public void printResult(){
		System.out.println("시작 = " + this.start);
		System.out.println("종료 = " + this.end);
		System.out.println("소요시간 = " + (this.end - this.start));
	}
	
	public void end(){
		this.end = System.currentTimeMillis();
	}
	
}
