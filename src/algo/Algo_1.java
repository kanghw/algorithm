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

	public static void algo_1_8(){
		String source = "waterbottle";
		String check = "erbottlewat";
		if( isSubString(source, check) ){
			System.out.println("포함");
		} else {
			System.out.println("미포함");
		}
	}

	private static boolean isSubString(String source, String check) {
		int len = check.length();
		if( source.length() != len ){
			return false;
		}
		for( int i = 0; i < len ; i++ ){
			String temp = check.substring( i, len ) + check.substring( 0, i);
			if( temp.equals(source) ){
				return true;
			}
		}
		return false;
	}



	public static void algo_1_5(){
		System.out.println("결과 = " + algo_1_5_m("abcde") + "\n");
		System.out.println("결과 = " + algo_1_5_m("abbbccddde") + "\n");
		System.out.println("결과 = " + algo_1_5_m("aabccdde") + "\n");
		System.out.println("결과 = " + algo_1_5_m("aabccddeedddddd") + "\n");
	}

	public static String algo_1_5_m(String source){
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

	public static void algo_1_6(){
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
		};
		arr_2_print(arr);

		int[][] result = new int[4][4];
		for (int i = 0; i < arr.length ; i++ ){
			for (int j = 0; j < arr[i].length ; j ++ ){
				result[j][i] = arr[i][j];
			}
		}
		arr_2_print(result);
	}

	public static void algo_1_6_dap(){
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
		};
		arr_2_print(arr);
		int n =4;
		for( int layer = 0; layer < n / 2; ++layer ){
			int first = layer;
			int last = n - 1 - layer;

			for( int i = first; i < last; ++i ){

				int offset = i - first;

				int top = arr[first][i];
				System.out.println("first = " + first + ", last = " + last + ", offset = " + offset + ", top = " + top + ", i = " + i + ", layer = " + layer );

				arr[first][i] = arr[last-offset][first];

				arr[last-offset][first] = arr[last][last - offset];

				arr[last][last - offset] = arr[i][last];

				arr[i][last] = top;
			}
		}
		arr_2_print(arr);
	}

	public static void arr_2_print(int[][] arr){
		for (int i = 0; i < arr.length ; i++ ){
			for (int j = 0; j < arr[i].length ; j ++ ){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void algo_1_7(){
		int[][] arr = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 0, 13, 14, 15},
				{16, 17, 18, 19, 20},
		};
		arr_2_print(arr);
		int[][] result = new int[4][5];
		// 0이 들어간 x, y 좌표 값 저장용.
		int x = -1, y = -1;
		for (int i = 0; i < arr.length ; i++ ){
			for (int j = 0; j < arr[i].length ; j ++ ){
				if( arr[i][j] == 0 ){
					x = i;
					y = j;
				}
				result[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < arr.length ; i++ ){
			for (int j = 0; j < arr[i].length ; j ++ ){
				if( i == x || j == y ){
					result[i][j] = 0;
				}
			}
		}
		arr_2_print(result);
	}

	public static String reverse(String str){
		String reverse = "";
		for ( int i = str.length(); i > 0; i-- ){
			reverse += str.substring(i - 1, i);
			System.out.println(i);
		}
		return reverse;
	}

	public static boolean test(String str){
		for ( int i = 0; i < str.length(); i++ ){
			String temp = str.substring(i, i + 1);
			//System.out.println(temp);
			if( !check(str, temp) ){
				return false;
			}
		}
		return true;
	}

	// 중복되는 것 체크.
	public static boolean check(String str, String c){
		String temp = str.replaceFirst(c, "");
		if( temp.indexOf(c) < 0 ) {
			return true;
		}
		return false;
	}

	// 2개의 문자열 입력으로 2번째 문자열이 첫번째 문자열에 포함되는지 확인. 1-3
	public static boolean pCheck(String source, String target){
		for ( int i = 0; i < target.length(); i++ ){
			String temp = target.substring( i, i+1 );
			if( source.indexOf(temp) < 0 ){
				return false;
			}else{
				source = source.replaceFirst( temp, "" );
			}
		}
		return true;
	}

	// 1-4
	public static String pCheck2(String source, int cnt){
		String t = "";
		for( int i = 0; i < cnt; i++ ){
			if( source.length() > i ){
				t += source.substring(i, i+1);
			}else{
				t += " ";
			}
		}
		return t.replaceAll(" ", "%20");
	}

}
