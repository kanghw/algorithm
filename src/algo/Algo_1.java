package algo;

public class Algo_1 {
	public static void main(String[] args) {
		System.out.println("결과 = " + algo_1_3("abcde") + "\n");
		System.out.println("결과 = " + algo_1_3("abbbccdddee") + "\n");
		System.out.println("결과 = " + algo_1_3("aabccdde") + "\n");
		System.out.println("결과 = " + algo_1_3("aabccddeedddddd") + "\n");
	}
	
	public static String algo_1_3(String source){
		int len = source.length();
		if( len <= 2 ){
			return source;
		}
		int cnt = 0;
		String curStr = "";
		String zipStr = "";
		for (int i = 0; i < len; i++) {
			String subStr = source.substring(i, i+1);
			if( i == 0 ){
				curStr = subStr;
			}
			if( !curStr.equals(subStr) ){
				zipStr += curStr + Integer.toString(cnt);
				cnt = 0;
				curStr = subStr;
			}
			cnt++;
			if( i == len - 1 ){
				zipStr += curStr + Integer.toString(cnt);
			}
		}
		System.out.println("원본 = " + source);
		System.out.println("압축 = " + zipStr);
		if( len > zipStr.length() ){
			return zipStr;
		}
		return source;
	}
}
