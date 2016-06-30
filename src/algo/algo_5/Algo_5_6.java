package algo.algo_5;

import algo.BitUitl;
import org.junit.Test;

/**
 * Created by we on 2016. 6. 23..
 */
public class Algo_5_6 {
    @Test
    public void test(){
        proc(30);
        proc2(100);
    }

    /**
     * 1011
     * 0100
     * 1111
     * 정수의 비트를 홀수번째와 짝수번째를 바꾸는 방법.
     * @param num
     */
    private void proc(int num) {
        int len = BitUitl.getLengthBit(num);
        System.out.println(" " + Integer.toBinaryString(num));
        for( int i = 0; i <= len; i+=2 ){
            num = change(num, i);
        }
        System.out.println(Integer.toBinaryString(num));
    }

    private void proc2(int num){
        boolean first = BitUitl.getBit(num, 0);
        int result = num << 1;
        if( first ){
            result = BitUitl.setBit(result, 0);
        } else {
            result = BitUitl.cleanBit(result, 0);
        }
        System.out.println(" " + Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(result));
    }

    private int change(int num, int i){
        boolean prev = BitUitl.getBit(num, i);
        boolean after = BitUitl.getBit(num, i+1);
        if( prev != after ) {
            if (prev) {
                num = BitUitl.setBit(num, i + 1);
            } else {
                num = BitUitl.cleanBit(num, i + 1);
            }
            if (after) {
                num = BitUitl.setBit(num, i);
            } else {
                num = BitUitl.cleanBit(num, i);
            }
        }
        return num;
    }

}
