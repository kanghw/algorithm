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
//        proc(103);
//        proc2(108);
        for( int i = 100; i < 200; i++ ){
            proc(i);
            System.out.println();
            proc2(i);
        }
    }

    /**
     * x 를 입력 받았을 때 x 의 2진수가 가지는 1의 개수를 n개라 하면 x보다 작은 정수 중 2진수 중 1을 n 개 가지는 가장 큰 수와
     * x 보다 큰 1을 n 개 가지는 정수 중 가장 작은 수를 구하라.
     *
     * x 의 1의 개수를 구한다.
     * x 보다 작은 수 중 가장 큰 수.
     * - x 의 2진수를 구한 후 우측에서부터 시작했을 때 10 이 처음 나오는 곳을 찾아서 1의 자리에 0을 넣고 그 우측을 모두 0으로 만든 후,
     *   그 이전에 있던 1의 개수만큼을 0으로 바꾼 자리 우측에 붙여 넣어준다.
     */
    public void proc(int x){
        System.out.println(Integer.toBinaryString(x) + " - " + x);
        // 바꿔치기할 1의 자릿수.
        int cnt = 0;
        int lessMax = x;
        // 1의 개수.
        int oneCount = 0;
        while( x > Math.pow(2, cnt) ){
            // 10 이 나오는 최초비트를 찾는다. 찾으면 1을 0으로 변경하고 oneCount ++
            if( bit.getBit(x, cnt + 1) && !bit.getBit(x, cnt) ){
                lessMax = BitUitl.cleanBit(lessMax, cnt + 1);
                oneCount ++;
                break;
            } else {
                // 10 이 아닐 경우 1의 개수 카운트.
                if( bit.getBit(x, cnt) ){
                    oneCount ++;
                }
            }
            // 자리수.
            cnt++;
        }
        // 자리수 이하 전체를 0으로 변경.
        lessMax = bit.clearBitsIthrought0(lessMax, cnt);
        // 1의 개수만큼 반복하면서 0으로 바꾼 자리수 우측부터 1을 채워 나간다.
        while( oneCount > 0 ){
            lessMax = BitUitl.setBit(lessMax, cnt);
            cnt --;
            oneCount --;
        }
        System.out.println(Integer.toBinaryString(lessMax) + " - " + lessMax + " = 작은 수 중에 큰 결과");
    }

    /**
     *  * - 0이 없을 경우에는 성립할 수 없음.
     * x 보다 큰 수 중 가장 작은 수.
     * - x 의 2진수를 구한 후 우측에서부터 시작했을 때 01 이 처음 나오는 자리에 0의 자리에 1을 넣고 그 우측에 있던 1의 개수만큼을 우측에서부터 채워 넣어준다.
     * - 0이 없을 경우에는 젤 좌측에 1을 하나 추가한 후에 그 우측을 0으로 만든다.
     */
    public void proc2(int x){
        System.out.println(Integer.toBinaryString(x) + " - " + x);
        int cnt = 0;
        int lessMin = x;
        int oneCount = 0;
        while( x > Math.pow(2, cnt) ){
            if( !bit.getBit(x, cnt + 1) && bit.getBit(x, cnt) ){
                lessMin = BitUitl.setBit(lessMin, cnt + 1);
                break;
            } else {
                if( bit.getBit(x, cnt) ){
                    oneCount ++;
                }
            }
            cnt++;
        }
        lessMin = bit.clearBitsIthrought0(lessMin, cnt);
        for( int i = 0; i < oneCount; i++ ){
            lessMin = BitUitl.setBit(lessMin, i);
        }
        System.out.println(Integer.toBinaryString(lessMin) + " - " + lessMin + " = 큰 수 중에 작은 결과");
    }

}
