package algo.algo_5;

import org.junit.Test;

/**
 * Created by we on 2016. 6. 22..
 */
public class Algo_5_4 {
    @Test
    public void test(){
        for( int i = 0 ; i < 100 ; i++ ){
            proc(i);
        }

    }
    // 2의 제곱승인지 판단하는 함수.
    public void proc(int n){
        if( (n & (n - 1)) == 0 ){
            System.out.println(n + " = 같음.");
        } else {
//            System.out.println(n + " = 다름.");
        }
    }
}
