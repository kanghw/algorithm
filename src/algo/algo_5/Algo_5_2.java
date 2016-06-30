package algo.algo_5;

import org.junit.Test;

/**
 * Created by we on 2016. 6. 20..
 */
public class Algo_5_2 {
    String result = "";
    @Test
    public void test(){
        double d = 0.27;
        proc(d);

//        System.out.println(result);

    }
//    public String proc(double d){
//        d = d * 2;
//        if( d == 1 ){
//            System.out.println("d == 1");
//            return "1";
//        } else if( d > 1 ){
//            System.out.println("d > 1");
//            result += proc(d - 1);
//        } else {
//            System.out.println("d < 1");
//            result += proc(d);
//        }
//        return "0";
//    }

    public void proc(double d){
        int cnt = 0;
        boolean isEnd = true;
        String result = "0.";
        while( d != 1 ){
            d = d * 2;
            if( d == 1 ){
                result += "1";
                break;
            } else if( d > 1 ){
                result += "1";
                d = d - 1;
            } else {
                result += "0";
            }
            cnt++;
            if( cnt > 32 ){
                isEnd = false;
                break;
            }
        }
        if( isEnd ){
            System.out.println(result);
        } else {
            System.out.println("ERROR");
        }
    }
}

