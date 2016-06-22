package algo.algo_5;

import algo.BitUitl;
import org.junit.Test;

/**
 * Created by we on 2016. 6. 20..
 */
public class Algo_5_1 {
    BitUitl bit = new BitUitl();

    @Test
    public void test(){
        int a = 465;
        int b = 9;
        int i = 1;
        int j = 4;

//        printBin(a);
////        a = bit.clearBitsMSBthroughI(a, 6);
////        a = bit.cleanBit(a, 4);
//        printBin(a);
//
//        printBin(b);
        proc(a, b, i, j);
    }

    public void printBin(int num){
        System.out.println(Integer.toBinaryString(num));
    }

    public void proc(int m, int n, int start, int end){
        int result = m;
        printBin(m);
        printBin(n);
        for( int i = start ; i <= end ; i++){
            if( bit.getBit(n, i - start) ){
                System.out.println(n + " 의 뒤에서 " + i + "번째 bit 값은 = 1");
                result = bit.setBit(result, i);
            } else {
                System.out.println(n + " 의 뒤에서 " + i + "번째 bit 값은 = 0");
                result = bit.cleanBit(result, i);
            }
        }
        printBin(result);
    }
}
