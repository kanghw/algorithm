package algo.algo_5;

import algo.BitUitl;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

/**
 * Created by we on 2016. 6. 20..
 */
public class Algo_5_3 {
    BitUitl bit = new BitUitl();
    @Test
    public void test(){
        int x = 1000;
        proc(x);
    }

    /**
     * x 를 입력 받았을 때 x 의 2진수가 가지는 1의 개수를 n개라 하면 x보다 작은 정수 중 2진수 중 1을 n 개 가지는 가장 큰 수와
     * x 보다 큰 1을 n 개 가지는 정수 중 가장 작은 수를 구하라.
     *
     * x 의 1의 개수를 구한다.
     * x 보다 작은 수 중 가장 큰 수.
     * - x 의 2진수를 구한 후 우측에서부터 시작했을 때 10 이 처음 나오는 자리에 01을 넣는다.
     * - 0이 없을 경우에는 성립할 수 없음.
     * x 보다 큰 수 중 가장 작은 수.
     * - x 의 2진수를 구한 후 우측에서부터 시작했을 때 01 이 처음 나오는 자리에 10을 넣는다.
     * - 0이 없을 경우에는 젤 좌측에 1을 하나 추가한 후에 그 우측을 0으로 만든다.
     */
    public void proc(int x){
        System.out.println(Integer.toBinaryString(x) + " - " + x);
//        System.out.println(bit.getBit(x, 0));

        // x 보다 작으면서 1의 개수가 같은 최대값.
        int cnt = 1;
        int lessMax = x;
        while( x > Math.pow(2, cnt) ){
//            System.out.println(Integer.toBinaryString(x) + " = " + cnt);
            if( bit.getBit(x, cnt) && !bit.getBit(x, cnt - 1) ){
//                System.out.println(Integer.toBinaryString(x) + " - " + cnt);
                lessMax = bit.cleanBit(lessMax, cnt);
                lessMax = bit.setBit(lessMax, cnt - 1);
                break;
            }
            cnt++;
        }
        System.out.println(Integer.toBinaryString(lessMax) + " - " + lessMax);

        int overMin = x;
        cnt = 0;
        while( x > Math.pow(2, cnt) ){
            if( !bit.getBit(x, cnt) && bit.getBit(x, cnt - 1) ){
//                System.out.println(Integer.toBinaryString(x) + " - " + cnt);
                overMin = bit.setBit(overMin, cnt);
                overMin = bit.cleanBit(overMin, cnt - 1);
                break;
            }
            cnt++;
        }
        System.out.println(Integer.toBinaryString(x) + " - " + x);
        System.out.println(Integer.toBinaryString(overMin) + " - " + overMin);

    }

}
