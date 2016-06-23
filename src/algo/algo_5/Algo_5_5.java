package algo.algo_5;

import algo.BitUitl;
import org.junit.Test;

/**
 * Created by we on 2016. 6. 22..
 */
public class Algo_5_5 {
    BitUitl bit = new BitUitl();
    @Test
    public void test(){
        int a = 28;
        int b = 15;
        System.out.println(proc(a, b));
    }

    // a, b 를 받아서 a를 b로 변경하는데 바꿔야 하는 bit 개수를 반환하라.
    /**
     * 같은 자리수라고 생각하고 각 자리수가 다른 개수가 변경해야 하는 개수이다.
     * 다른 자리수일 땐 자리수의 차이가 기본 차이이고 거기에 짧은 길이를 기준으로 각 자리가 다를 경우를 더하면 전체 차이를 알 수 있음.
     */

    public int proc(int a, int b){
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        System.out.println( bit.getLengthBit(a) + " - " + bit.getLengthBit(b) );
        int aLen = bit.getLengthBit(a);
        int bLen = bit.getLengthBit(b);

        int diff = Math.abs(aLen - bLen);
        for( int i = 0 ; i < (aLen < bLen ? aLen : bLen) ; i++ ){
            if( bit.getBit(a, i) != bit.getBit(b, i) ){
                diff ++;
            }
        }
        return diff;
    }


}
