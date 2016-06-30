package algo.algo_5;

import algo.BitUitl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by we on 2016. 6. 23..
 */
public class Algo_5_7 {
    int loseNum = -1;
    int checkLoseNum = -1;
    @Test
    public void test(){
        for( int i = 0; i < 10; i++ ){
            int[] a = createIntArr((int)(Math.random() * 10000));
            proc(a);
            System.out.println();
        }
    }

    /**
     * 전체 길이 n 의 배열이 들어왔을 경우 0~n 까지의 정수 중에 랜덤하게 하나의 정수가 빠져있다.
     * 이 정수를 구하는 함수를 만들고 가장 적은 연산을 수행하도록 하라.
     * 단 가능한 것은 a[i] 번째 정수에서 j번째 비트만을 가져올 수 있다.
     *
     * 배열의 중간을 구해서 그 중간의 0번째 비트를 구한다.
     * 구한 비트가 0이면 i 가 짝수이고 1이면 i가 홀수이다.
     * 위의 조건을 만족하면 i 와 n 사이의 중간을 구해서 반복.
     * 위의 조건을 만족하지 못하면 이전의 i / 2 와 i 사이의 중간을 구해서 반복.
     * @param a
     */
    private void proc(int[] a){
        int len = a.length;
        int mid = len / 2;
        if( BitUitl.getBit(a[0], 0) ){
            System.out.println("빠진 숫자 = 0");
            return;
        }
        int cnt = 0;
        while( true ) {
            cnt++;
            boolean isDouble = (mid % 2 == 0);
            if ( (BitUitl.getBit(a[mid], 0) && !isDouble) || (!BitUitl.getBit(a[mid], 0) && isDouble) ) {
                // 원래 수가 맞을 경우 상위 전체 길이와의 중간을 구한 후 반복.
                mid = (len - mid) / 2 + mid;
            } else {
                // 원래 수가 아닐 경우 len / 2 부터 mid 사이 반복.
                len = mid;
                mid = len / 2;
            }
            // 1차이가 날 경우 mid 또는 len 이 빠진 숫자이다.
            if( len - mid == 1 ){
//                printIntArr(a);
//                System.out.println("2 > len = " + len + ", mid = " + mid + ", isDouble = " + isDouble);
                // 배열 a[mid] 와 mid 가 홀수 짝수가 다를 경우에는 빠진 값이 a[mid] - 1 이며 같을 경우에는 a[mid] + 1 이다.
                if( (BitUitl.getBit(a[mid], 0) && mid % 2 == 1) || (!BitUitl.getBit(a[mid], 0) && mid % 2 == 0) ){
                    checkLoseNum = a[mid] + 1;
                    System.out.println("빠진 숫자 = " + (a[mid] + 1) + ", 반복 횟수 = " + cnt);
                } else {
                    checkLoseNum = a[mid] - 1;
                    System.out.println("빠진 숫자 = " + (a[mid] - 1) + ", 반복 횟수 = " + cnt);
                }
                break;
            }
        }
        Assert.assertTrue(loseNum == checkLoseNum);
    }

    private int[] createIntArr(int n){
        int[] a = new int[n];
        int rand = (int)(Math.random() * 1000);
        rand = rand % (n - 1);
        loseNum = rand;
        System.out.println("빠진 숫자 = " + rand + ", 전체 길이 = " + n);
        for( int i = 0; i < n; i++ ){
            if( i < rand ){
                a[i] = i;
            } else {
                a[i] = i + 1;
            }
        }
        return a;
    }

    private void printIntArr(int[] a){
        String result = "";
        for (int i = 0; i < a.length; i++ ){
            result += a[i] + ", ";
        }
        result = result.substring(0, result.length() - 2);
        System.out.println(result);
    }
}
